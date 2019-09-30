package com.github.doraexplorer

import android.app.Application

class MyApplication: Application() {

    data class Scene(
        val body: String,
        val actions: List<String>
    )

    companion object {
        // Constants
        val MAIN_MENU = "Main Menu"
        val TRY_AGAIN = "Try Again"


        // Scenes
        val scenes: List<Scene> = listOf (
            // 0
            Scene (
                "Dora Need your help to guide her to home, What you do",
                listOf("Refuse to Help", "Wander around together")),

            // 1
            Scene (
                "A Kidnapper came to Dora and want to kidnap Dora",
                actions = listOf("Run Away Alone","Hide Together")),

            // 2 BAD END Kidapped
            Scene (
                "Dora ran, but Dora isn't fast enough to outrun the kidnapper. Dora scream loudly as the kidnapper kidnapped her.",
                actions = listOf (MAIN_MENU, TRY_AGAIN)),

            // 3
            Scene (
                "You Choose to hide together with Dora, but where do you choose to hide.",
                actions = listOf ("Hide in the nearby house", "Hide in the bushes")),


            // 4 BAD END Kidnapper Found you
            Scene (
                "You choose to hide in the bushes, but the kidnapper smell your parfume and found you and Dora in the bushes",
                actions = listOf(MAIN_MENU, TRY_AGAIN)),

            // 5
            Scene (
                "You choose to hide in a house nearby. Now you can stay here until morning, or get out during midnight.",
                actions = listOf("Stay until morning", "Go during midnight")),

            // 6 BAD END
            Scene (
                "You choose stay until morning, but then suddenly the kidnapper enters the house, and kidnapped you and Dora.",
                actions = listOf(MAIN_MENU, TRY_AGAIN)),

            // 7
            Scene (
                "You get out during midnight, and then you and Dora want to go home. But there are two paths you can choose, one that goes through flower garden, or dangerous jungle.",
                actions = listOf("Go through the garden", "Go through the jungle")),

            // 8 NORMAL ENDING
            Scene (
                "You went through the garden, and you and Dora got home safely.",
                actions = listOf (MAIN_MENU, TRY_AGAIN)),

            // 9 GOOD END
            Scene (
                "You went through the jungle, and on the way, you found Boots. Together with Dora and Boots, you went home.",
                actions = listOf (MAIN_MENU, TRY_AGAIN))
        )

        // Ending flags
        var badEnding = false
        var normalEnding = false
        var goodEnding = false

        // Utils
        lateinit var currentDisplayedEnding: Scene
    }
}