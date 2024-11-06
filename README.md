Dell Latittude 7520# Stop Watch App ⏱️

This is a simple Android Stop Watch app built using Kotlin and the Android SDK. It features a user-friendly interface that allows users to start, stop, and reset the timer with precise time tracking (minutes, seconds, and milliseconds).

## Features ✨

- **Start, Stop, Reset Buttons**: Provides functionality to start, stop, and reset the timer. 🟢🛑🔄
- **Time Display**: Displays elapsed time in the format `MM:SS:MM`. 🕑
- **Real-time Updates**: The time updates every 50 milliseconds using a Handler. ⏳

## Screenshots 📸

![Screenshot 2024-11-06 131331](https://github.com/user-attachments/assets/142379d3-215d-426e-888a-50d40b32e6fb)

## Tech Stack 🧰

- **Programming Language**: Kotlin 🖥️
- **IDE**: Android Studio 💡
- **Android SDK**: Used for building the app and providing necessary APIs 🛠️
- **UI Framework**: XML Layouts, ConstraintLayout for UI design 🖼️
- **Libraries**: Android Handler for updating the UI on the main thread ⚙️

## Usage 🚀

- **Start Button**: Press the `START` button to begin the timer. The `STOP` button will be enabled once the timer starts. 🟢
- **Stop Button**: Press the `STOP` button to halt the timer. The `START` and `RESET` buttons will be enabled. 🛑
- **Reset Button**: Press the `RESET` button to reset the timer to `00:00:00`. 🔄

## Code Explanation 📚

### MainActivity

- **Handler**: Used to update the UI at regular intervals (every 50 milliseconds). 🕰️
- **Runnable**: Runs the update logic for the timer. ⚙️
- **Time Calculation**: Elapsed time is calculated using `SystemClock.uptimeMillis()`, which is precise and keeps track of the time from the system boot. ⏳

## Requirements 📋

- **Android Studio** 4.0 or higher 💻
- **Android API** 21+ (Lollipop) or higher 📱

## Installation 🛠️

To run this project, clone the repository and open it in Android Studio.

```bash
git clone https://github.com/Surendhar-V/StopWatch.git
