package dev.johnoreilly.confetti.wear

import dev.johnoreilly.confetti.GetConferencesQuery.Conference
import dev.johnoreilly.confetti.fragment.SessionDetails
import dev.johnoreilly.confetti.fragment.SpeakerDetails
import dev.johnoreilly.confetti.wear.proto.Theme
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

object TestFixtures {
    val sessionTime = LocalDateTime.parse("2023-04-13T14:00")

    // Generate from FetchDataTest.fetchConferences
    val conferences = listOf(
        Conference(
            "kotlinconf2023",
            listOf(
                LocalDate.parse("2023-04-12"),
                LocalDate.parse("2023-04-13"),
                LocalDate.parse("2023-04-14")
            ),
            "KotlinConf 2023"
        ),
        Conference(
            "fosdem2023",
            listOf(LocalDate.parse("2023-02-04"), LocalDate.parse("2023-02-05")),
            "Fosdem 2023"
        ),
        Conference(
            "droidconlondon2022",
            listOf(LocalDate.parse("2022-10-27"), LocalDate.parse("2022-10-28")),
            "droidcon London"
        ),
        Conference(
            "devfestnantes",
            listOf(LocalDate.parse("2022-10-20"), LocalDate.parse("2022-10-21")),
            "DevFest Nantes"
        ),
        Conference(
            "graphqlsummit2022",
            listOf(LocalDate.parse("2022-10-04"), LocalDate.parse("2022-10-05")),
            "GraphQL Summit"
        ),
        Conference(
            "frenchkit2022",
            listOf(LocalDate.parse("2022-09-29"), LocalDate.parse("2022-09-30")),
            "FrenchKit"
        ),
        Conference(
            "droidconsf",
            listOf(LocalDate.parse("2022-06-02"), LocalDate.parse("2022-06-03")),
            "droidcon SF"
        )
    )

    val JohnOreilly = SessionDetails.Speaker(
        __typename = "Speaker",
        speakerDetails = SpeakerDetails(
            id = "0392772c-28d4-47f6-bd39-47d743fb4a81",
            name = "John O'Reilly",
            photoUrl = "https://sessionize.com/image/48e7-400o400o2-HkquSQhsfczBGkrABwVTBc.jpg",
            company = null,
            companyLogoUrl = null,
            city = null,
            bio = "John is a Kotlin GDE that has been developing Android apps since 2010. He worked on server side Java applications in the 2000s and desktop clients in the 1990s. He's also been exploring and advocating for all things Kotlin Multiplatform since 2018.",
            socials = listOf(

            )
        )
    )

    val MartinBonnin = SessionDetails.Speaker(
        __typename = "Speaker",
        speakerDetails = SpeakerDetails(
            id = "56fda597-4927-4d25-9a80-4795d15ef080",
            name = "Martin Bonnin",
            photoUrl = "https://sessionize.com/image/7c96-400o400o2-UiWeCMZDxPejrFsozKmLYr.jpeg",
            company = null,
            companyLogoUrl = null,
            city = null,
            bio = "Martin is a maintainer of Apollo Kotlin. He has been writing Android applications since Cupcake and fell in love with Kotlin in 2017. Martin loves naming things and the sound of his laptop fan compiling all these type-safe programs. When not busy rewriting all his bash scripts in Kotlin, Martin loves to hike the Pyrénées or play a good game of Hearthstone.",
            socials = listOf(

            )
        )
    )

    val sessionDetails = SessionDetails(
        id = "368995",
        title = "Confetti: building a Kotlin Multiplatform conference app in 40min",
        type = "talk",
        startsAt = LocalDateTime.parse("2023-04-13T14:00"),
        endsAt = LocalDateTime.parse("2023-04-13T14:45"),
        sessionDescription = """In this talk Martin and John will live code the development of Confetti, a fullstack conference app using a graphql-kotlin backend and KMM based mobile clients

The talk will cover
- development of the graphql-kotlin backend
- use of Apollo library and it's Kotlin Multiplatform support allowing addition of GraphQL queries and related logic in code shared between iOS and Android clients.
- development of mobile clients that consume the shared KMM code (using Jetpack Compose on Android and SwiftUI on iOS)""",
        language = "en-US",
        speakers = listOf(
            JohnOreilly,
            MartinBonnin
        ),
        room = SessionDetails.Room(name = "Effectenbeurszaal"),
        tags = listOf(),
        __typename = "Session"
    )

    val MobileTheme = Theme(
        primary = -32579010567340032,
        primaryVariant = -46196668235776,
        secondary = -26389284088971264,
        secondaryVariant = -22011707392000,
        background = 0,
        surface = -847740644884480,
        error = -19673445591678976,
        onPrimary = -4294967296,
        onSecondary = -4294967296,
        onBackground = -63021691516747776,
        onSurface = -63021691516747776,
        onSurfaceVariant = -50027452646293504,
        onError = -4294967296
    )
}