package com.konrados.android_studio_study_kotlin.navigation
// ↑ To tylko adres „folderu logicznego” w projekcie (pakiet). Dzięki temu inne pliki
//   mogą nas łatwo importować. Nazwa musi odpowiadać strukturze katalogów.

// ───────────────────────────── IMPORTY ─────────────────────────────

import android.net.Uri
// ↑ Klasa do „bezpiecznego pakowania” tekstu do adresu (np. spacje → %20). Potrzebne,
//   żeby login z polskimi znakami/spacjami nie rozwalił trasy „welcome/{username}”.

import androidx.compose.runtime.Composable
// ↑ Adnotacja mówiąca „to jest funkcja rysująca UI w Compose”.

import androidx.navigation.NavType
// ↑ Typy argumentów tras (String, Int itd.). Powiemy nawigacji, że „username” jest Stringiem.

import androidx.navigation.compose.NavHost
// ↑ Główny „router” Compose. On trzyma informację: jaki ekran jest startowy i jakie mamy trasy.

import androidx.navigation.compose.composable
// ↑ Rejestracja pojedynczego ekranu w routerze: mówisz „dla tej ścieżki odpal ten Composable”.

import androidx.navigation.navArgument
// ↑ Narzędzie do zdefiniowania argumentów trasy (np. że mamy parametr o nazwie "username").

import androidx.navigation.NavHostController
import com.konrados.android_studio_study_kotlin.screens.QuestionsScreenView
// ↑ Pilot do nawigacji. Przez niego mówimy „przejdź na inny ekran”.

import com.konrados.android_studio_study_kotlin.screens.StartScreenView
// ↑ Twój ekran logowania (Composable), który zbiera login i wywoła callback „onLoginSuccess”.

import com.konrados.android_studio_study_kotlin.screens.WelcomeScreen
// ↑ Ekran powitalny (Composable), który wyświetla „Witaj, <username>”.

// ───────────────────────────── NAV HOST ─────────────────────────────

@Composable
fun AppNavHost(nav: NavHostController) {
    // ↑ Definiujemy funkcję rysującą „kontener nawigacji”.
    //   Parametr „nav” to pilot, którym będziemy sterować przejściami między ekranami.

    NavHost(
        navController = nav,            // ← Mówimy, którym pilotem (NavController) steruje ten host
        startDestination = Routes.STARTSCREEN // ← Który ekran ma się włączyć jako pierwszy po starcie apki
    ) {
        // ↑ Od tego momentu, w tym bloku { ... }, rejestrujemy konkretne ekrany (trasy).

        composable(route = Routes.STARTSCREEN) { // ← Rejestrujemy trasę „login” → co ma się narysować?
            // ↑ Gdy ktoś „wejdzie” na /login, to zawartość TEGO bloku zostanie pokazana.

            StartScreenView(
                onLoginSuccess = { username ->            // ← Callback z ekranu logowania:
                    //    LoginScreen (u Ciebie StartScreenView) zawoła to po kliknięciu „Zaloguj”
                    //    i przekaże tu tekst wpisany przez użytkownika (username).

                    val safe = Uri.encode(username.trim()) // ← 1) obcinamy spacje z boków (trim)
                    //                                           np. "  Konrad  " → "Konrad"
                    //                                        2) kodujemy znaki do adresu (encode)
                    //                                           np. spacje/PL-znaki → bezpieczny URL

                    nav.navigate("welcome/$safe") {        // ← Mówimy routerowi: przejdź do
                        //                                      ścieżki „welcome/<tu_login>”.
                        //                                      To podmienia {username} w szablonie.

                        popUpTo(Routes.STARTSCREEN) { inclusive = true }
                        // ↑ Sprzątanie stosu ekranów:
                        //   „popUpTo(LOGIN)” usuwa wszystkie ekrany aż do „login”,
                        //   a „inclusive = true” usuwa też sam ekran „login”.
                        //   Efekt: po zalogowaniu wciśnięcie „wstecz” NIE cofnie nas do logowania.

                        launchSingleTop = true
                        // ↑ Jeśli z jakiegoś powodu klikniesz nawigację do tego samego ekranu
                        //   kilka razy z rzędu, to nie będzie duplikatów tego samego ekranu
                        //   na stosie (utrzymuje pojedynczy „top”).
                    }
                }
            )
            // ↑ Koniec konfiguracji ekranu logowania.
        }

        composable(
            route = Routes.WELCOME, // ← Mówimy: ta deklaracja dotyczy ścieżki "welcome/{username}"
            arguments = listOf(     // ← Lista argumentów, których spodziewa się ta trasa
                navArgument("username") { type = NavType.StringType }
                // ↑ Deklarujemy, że w ścieżce jest parametr o nazwie „username” i że to String.
            )
        ) { backStackEntry ->

            // ↑ Ten blok odpala się, gdy nawigacja wejdzie na trasę „welcome/<coś>”.
            //   „backStackEntry” to „plecak” z informacjami o tym wejściu:
            //   zawiera argumenty, które zostały wstrzyknięte w ścieżkę.

            val user = backStackEntry
                .arguments               // ← Wyciągamy paczkę argumentów przekazanych w adresie
                ?.getString("username")  // ← Bierzemy konkretnie wartość o kluczu „username”
                .orEmpty()
            // ↑ Jeśli cokolwiek byłoby null (np. brak argumentu),
            //   to .orEmpty() sprawi, że dostaniemy pusty String zamiast crasha.

            WelcomeScreen(
                username = user,
                onOpenQuestions = {id ->
                    nav.navigate("questions/$id")

                }
            )

        }
        // ↑ Koniec konfiguracji ekranu WELCOME.
        composable(
            route = Routes.QUESTIONS,
            arguments = listOf(navArgument("conditionId"){ type = NavType.StringType })
        ){ backStackEntry ->
            val id = backStackEntry.arguments?.getString("conditionId").orEmpty()
            // TODO: tu w przyszłości QuestionsScreen(id)
            QuestionsScreenView()
        }


    }
    // ↑ Koniec NavHost: mamy zdefiniowane trasy i zachowania.
}
