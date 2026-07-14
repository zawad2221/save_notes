# SaveNotes

SaveNotes is a modern, fully modularized Android application designed for efficient note-taking. It is built using the latest Android development best practices, including Jetpack Compose for a declarative UI, clean architecture principles, and a multi-module project structure.

## Features

-   **Note Management**: Create, view, edit, and delete notes easily.
-   **Pinning & Organization**: Pin important notes to the top of your list for quick access. Supports toggling pin state during note creation and bulk pinning/unpinning of multiple selected notes.
-   **Search Functionality**: Quickly find specific notes using a dedicated search screen with real-time query matching and bulk actions.
-   **Selection Mode**: Long-press notes to enter selection mode, allowing for bulk deletion or bulk pinning/unpinning.
-   **Theme Customization**: Switch between System Default, Light, and Dark modes via a settings dialog. Preferences are persisted across sessions.
-   **Modern UI/UX**: Clean, responsive layout leveraging a custom design system with dark/light alpha coloring and a staggered grid note arrangement.

## Architecture & Tech Stack

The project follows Clean Architecture and Guide to App Architecture recommendations:

-   **UI Layer**: Built entirely with **Jetpack Compose** for modern, reactive, and declarative layouts. Uses **StateFlow** and `collectAsStateWithLifecycle()` for lifecycle-aware state handling.
-   **Dependency Injection**: **Hilt** (Dagger) manages dependency injection across modules, including ViewModels and repositories.
-   **Data Layer**:
    -   **Room Database**: Persistent storage for notes utilizing custom `TypeConverters` and **kotlinx-datetime** for robust temporal data handling.
    -   **DataStore (Proto)**: Type-safe data storage for user preferences (theme config) and note pinning states using Protocol Buffers.
-   **Asynchronous & Reactive Programming**: Extensive use of **Kotlin Coroutines** and **Flow** for structured concurrency and reactive data streams.

## Project Structure

The app is highly modularized to ensure separation of concerns, build scalability, and reusability:

-   `:app` - The main application entry point that stitches features and core modules together.
-   `:feature:notes` - Houses the notes landing screen, view/edit screen, and note-taking logic.
-   `:feature:search` - Contains note search logic and the dedicated search screen.
-   `:core:database` - Manages the Room database, DAOs, and entities for data persistence.
-   `:core:datastore` - Manages local user preferences and flags via Jetpack DataStore.
-   `:core:datastore-proto` - Contains Protocol Buffer definitions and serializers for DataStore.
-   `:core:data` - The data repository layer bridging database entities to domain models.
-   `:core:model` - Pure Kotlin domain models shared across modules (e.g., `NoteModel`).
-   `:core:ui` (`:design-system`, `:commonui`) - Centralized UI components, theme definitions, typography, shapes, colors, and reusable composables.
-   `:core:common` & `:core:constants` - Shared utility classes, extensions, and application-wide constants.