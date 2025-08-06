package sample;

import java.io.FileWriter;
import java.io.IOException;

public class Controller {

    @FXML
    private TextField nameField, emailField, phoneField, jobTitleField, companyField, yearsField, schoolField, degreeField, gradYearField;
    
    @FXML
    private TextArea summaryField;

    @FXML
    private Label statusLabel;

    // Handle the "Generate Resume" button click
    @FXML
    public void handleGenerateResume() {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String summary = summaryField.getText();
        String jobTitle = jobTitleField.getText();
        String company = companyField.getText();
        String years = yearsField.getText();
        String school = schoolField.getText();
        String degree = degreeField.getText();
        String gradYear = gradYearField.getText();

        // Create the resume text content
        String resumeContent = generateResumeText(name, email, phone, summary, jobTitle, company, years, school, degree, gradYear);

        // Choose where to save the resume
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName(name + "_Resume.txt");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        Stage stage = (Stage) statusLabel.getScene().getWindow();
        try {
            // Save the resume to a file
            FileWriter fileWriter = new FileWriter(fileChooser.showSaveDialog(stage).getAbsolutePath());
            fileWriter.write(resumeContent);
            fileWriter.close();
            
            statusLabel.setText("Resume generated successfully!");
        } catch (IOException e) {
            statusLabel.setText("Error saving the file.");
        }
    }

    // Method to generate the resume text
    private String generateResumeText(String name, String email, String phone, String summary,
                                      String jobTitle, String company, String years,
                                      String school, String degree, String gradYear) {
        return "Name: " + name + "\n" +
               "Email: " + email + "\n" +
               "Phone: " + phone + "\n\n" +
               "Professional Summary:\n" + summary + "\n\n" +
               "Experience:\n" +
               jobTitle + " at " + company + " (" + years + " years)\n\n" +
               "Education:\n" +
               degree + " from " + school + ", Graduated in " + gradYear;
    }
}
