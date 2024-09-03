import com.google.cloud.tools.jib.api.Containerizer
import com.google.cloud.tools.jib.api.DockerDaemonImage
import com.google.cloud.tools.jib.api.Jib
import com.google.cloud.tools.jib.api.RegistryImage
import com.google.cloud.tools.jib.api.buildplan.AbsoluteUnixPath
import gratatouille.GInputFile
import gratatouille.GInputFiles
import gratatouille.GTaskAction
import kotlin.io.path.name


@GTaskAction
fun buildImage(
    jarFile: GInputFile,
    gcpServiceAccountJson: String?,
    runtimeClasspath: GInputFiles,
    imageName: String,
    mainClass: String,
) {
    val path = jarFile.toPath()
    val imageRef: String
    val containerizer = if (gcpServiceAccountJson != null) {
        val repo = "${imageName}-images"
        imageRef = "$gcpRegion-docker.pkg.dev/$gcpProjectName/$repo/${imageName}"
        Containerizer.to(RegistryImage.named(imageRef).addCredential("_json_key", gcpServiceAccountJson))
    } else {
        imageRef = "confetti.${imageName}:latest"
        Containerizer.to(DockerDaemonImage.named(imageRef))
    }

    Jib.from("openjdk:17-alpine")
        .addLayer(listOf(path), AbsoluteUnixPath.get("/"))
        .addLayer(runtimeClasspath.map { it.file.toPath() }, AbsoluteUnixPath.get("/classpath"))
        .setEntrypoint(
            "java",
            "-cp",
            (runtimeClasspath.map { "classpath/${it.file.name}" } + path.name).joinToString(":"),
            mainClass)
        .containerize(containerizer)

    println("Image deployed to '$imageRef'")
}