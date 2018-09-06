import java.awt.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class that presents a quiz.
 * <p>
 * The provided code is incomplete and may contain errors. Modify it so that it calculates the final
 * score correctly and passes the unit tests in <code>QuizzerTest.java</code>.
 *
 * @see <a href="https://cs125.cs.illinois.edu/MP/0/">MP0 Documentation</a>
 */

public final class Quizzer {

    private static final int POINTS_PER_QUESTION = 5;

    /**
     * Compute a score based on entered answers.
     * <p>
     * Write this function. Each correct answer is worth five points.
     *
     * @param diversityAnswerCorrect respondent's answer to the diversity question is correct
     * @param illiacAnswerCorrect respondent's answer to the ILLIAC question is correct
     * @param mosaicAnswerCorrect respondent's answer to the Mosaic question is correct
     * @param variableAnswerCorrect respondent's answer to the variable properties question is
     *        correct
     * @return the correct score for these answers.
     *
     * @see <a href="https://goo.gl/xCPdep">CS@Illinois Honored for Increasing Women's Participation
     *      in Computing</a>
     * @see <a href="https://en.wikipedia.org/wiki/ILLIAC">ILLIAC Wikipedia Page</a>
     * @see <a href="https://en.wikipedia.org/wiki/Mosaic_(web_browser)"> Mosaic Browser Wikipedia
     *      Page</a>
     */

    public static int computeScore(final Boolean diversityAnswerCorrect,
            final Boolean illiacAnswerCorrect, final Boolean mosaicAnswerCorrect,
            final Boolean variableAnswerCorrect)
    {
        int score = 0;

        if (diversityAnswerCorrect){
            score += POINTS_PER_QUESTION;
        }

        if (illiacAnswerCorrect){
            score += POINTS_PER_QUESTION;
        }

        if (mosaicAnswerCorrect){
            score += POINTS_PER_QUESTION;
        }

        if (variableAnswerCorrect){
            score += POINTS_PER_QUESTION;
        }
        return score;
    }

    /* *******************************************************************************************
     * You do not need to modify code below this comment.
     * ********************************************************************************************/

    /**
     * Presents a quiz to the user, solicits answers, and computes a quiz score.
     * <p>
     * You are free to review this function, but should not modify it. Note that this function is
     * not tested by the test suite, as it is purely to aid your own interactive testing.
     *
     * @param unused unused input parameters.
     */
    public static void main(final String[] unused) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Which CS department was recently awarded $100,000 "
                + "for improving gender diversity?");
        System.out.println("1. Berkeley");
        System.out.println("2. Illinois");
        System.out.println("3. Harvard");
        Boolean diversityAnswerCorrect = getLineMatching("Please enter 1, 2, or 3:", inputScanner,
                "[123]").equals("2");

        System.out.println("Which CS department built the pioneering "
                + "ILLIAC series of computers?");
        System.out.println("1. Berkeley");
        System.out.println("2. Illinois");
        System.out.println("3. Harvard");
        Boolean illiacAnswerCorrect = getLineMatching("Please enter 1, 2, or 3:", inputScanner,
                "[123]").equals("2");

        System.out.println("Which university released Mosaic, the first cross-platform "
                + "multimedia internet browser?");
        System.out.println("1. Illinois");
        System.out.println("2. Purdue");
        System.out.println("3. Michigan");
        Boolean mosaicAnswerCorrect = getLineMatching("Please enter 1, 2, or 3:", inputScanner,
                "[123]").equals("1");

        System.out.println("True or false: Java variables have a type, name, value, and color.");
        System.out.println("1. True");
        System.out.println("2. False");
        Boolean variableAnswerCorrect = getLineMatching("Please enter 1 or 2:", inputScanner,
                "[12]").equals("2");

        int totalScore = computeScore(diversityAnswerCorrect, illiacAnswerCorrect,
                mosaicAnswerCorrect, variableAnswerCorrect);
        System.out.println(String.format("You scored: %d", totalScore));
    }

    /**
     * @param errorPrompt prompt to show on error
     * @param inputScanner an instance of the Scanner class to read lines from
     * @param regex a regular expression to match the input against
     * @return a string matching the pattern
     */
    private static String getLineMatching(final String errorPrompt, final Scanner inputScanner,
            final String regex) {
        Pattern pattern = Pattern.compile(regex);
        while (true) {
            Matcher matcher = pattern.matcher(inputScanner.nextLine());
            if (matcher.matches()) {
                return matcher.group();
            } else {
                System.err.println(errorPrompt);
            }
        }
    }
}
