# Mind Reader 3000

Mind Reader 3000 is a fun Java Swing-based desktop application that claims to read your mind! Think of a number between 1 and 10, and after some "analysis" and a colorful animation, the app will guess the number you're thinking of.

## Features

- **Mind-reading illusion**: The app walks through an animated process of reading your mind.
- **Interactive UI**: Colorful progress bar and random color changes for an engaging experience.
- **Dynamic Countdown**: A suspenseful countdown animation before revealing the number.
- **Humorous pop-up**: A final message that jokes about how good the app is at "mind reading".


## Installation

1. **Clone the repository**:
    ```bash
    git clone https://github.com/yourusername/MindReader3000.git
    cd MindReader3000
    ```

2. **Compile the code**:
    Use any Java compiler, such as `javac`, or use an IDE like IntelliJ IDEA or Eclipse to open the project.

    For example, using `javac`:
    ```bash
    javac MindReaderSwing.java
    ```

3. **Run the program**:
    ```bash
    java MindReaderSwing
    ```

## How It Works

1. The user is prompted to think of a number between 1 and 10.
2. The app simulates a "mind-reading" process using animated progress bars and dynamic label colors.
3. After a suspenseful countdown, the app reveals the number the user thought of (which they input during the process).
4. Finally, a pop-up message appears, praising the app's "mind-reading" skills.

## Code Explanation

### Main Components

- **`JLabel`**: Displays the prompts and the countdown.
- **`JProgressBar`**: Displays an animated progress bar with color changes.
- **`JButton`**: Triggers the mind-reading process.
- **`JOptionPane`**: Used to get user input (the number they are thinking of).
- **`Timer` and `Thread.sleep()`**: Used for timing the animations and countdown.

### Animation

The progress bar and the label colors dynamically change as the "analysis" proceeds. The countdown adds a fun element of suspense before revealing the result.

## Customization

- **Messages**: You can modify the messages in the `messages` array to change the text that appears during the animation.
    ```java
    private String[] messages = {"Analyzing", "Processing", "Reading your mind", "Almost there!"};
    ```
- **Colors**: Adjust the colors used for the progress bar and labels by modifying the `Color` objects in the code.
    ```java
    // Progress bar color
    progressBar.setForeground(new Color(102, 205, 170));  // Cool turquoise

    // Button colors
    button.setBackground(new Color(70, 130, 180));  // Cool steel blue
    button.setForeground(Color.WHITE);

    // Label color changes
    label.setForeground(new Color(255, random.nextInt(256), random.nextInt(256))); // Random colors
    ```


