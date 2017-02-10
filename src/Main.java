public class Main {

    public static void main(String[] args) throws Exception {

        Survey survey = new Survey();

        try {
            survey.loadResponse();

        } catch (Exception e) {
            System.out.println("Welcome to the musical artist survey!\n" +
                    "We could not find any pre-existing survey responses." +
                    "\nThis may be your first time taking this survey.\n");
        }

        if (survey.checkFileExistence()) {
            survey.displayResponse();
            survey.updateSurvey();

        } else {

            survey.createFile();

        }


    }
}





