public class RecommendationEngine {
    public static String getSuggestions(double emission) {
        if (emission > 15) {
            return "Status: HIGH\n\n"
                    + "- Use public transport\n"
                    + "- Reduce electricity usage\n"
                    + "- Recycle more waste\n"
                    + "- Avoid unnecessary travel";
        } else if (emission > 8) {
            return "Status: MEDIUM\n\n"
                    + "- Try to save electricity\n"
                    + "- Reduce waste production\n"
                    + "- Walk or cycle when possible";
        } else {
            return "Status: LOW\n\n"
                    + "- Great job! Keep it up!\n"
                    + "- Continue your eco-friendly habits";
        }
    }
}