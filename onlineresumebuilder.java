import java.util.*;

public class onlineresumebuilder {
    // Collaborative feedback method
    public static String getFeedback(int rating) {
        switch (rating) {
            case 1:
                return "Needs significant improvement in teamwork. Considering working on communication and openness to others' ideas.";
            case 2:
                return "Some collaboration skills present, but working on room for growth in listening and contributing effectively.";
            case 3:
                return "Above average collaborator. This individual works fairly well with others but could further develop adaptability and shared ownership.";
            case 4:
                return "Good collaborator! This individual communicates clearly, listens actively, and supports team goals.";
            case 5:
                return "Excellent collaborative skills! This individual is a team player who fosters trust, coordination, and shared success.";
            default:
                return "Error: enter a value between 1-5";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Personal info
        System.out.print("Enter your first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter your gmail: ");
        String gmail = sc.nextLine();
        System.out.print("Enter your phone number: ");
        String phone = sc.nextLine();
        System.out.print("Enter your LinkedIn (if made, else skip): ");
        String linkedin = sc.nextLine();
        System.out.print("Enter your current residential address: ");
        String address = sc.nextLine();
        System.out.print("Enter your Suburb: ");
        String suburb = sc.nextLine();
        System.out.print("Enter your post code: ");
        String postCode = sc.nextLine();

        // Interpersonal skills
        ArrayList<String> interpersonalSkills = new ArrayList<>();
        System.out.println("Enter your interpersonal skills (max 5). Type 'y' when done:");
        while (interpersonalSkills.size() < 5) {
            String skill = sc.nextLine();
            if (skill.equalsIgnoreCase("y")) break;
            if (!skill.trim().isEmpty()) interpersonalSkills.add(skill);
        }

        // Technical skills
        ArrayList<String> technicalSkills = new ArrayList<>();
        System.out.println("Enter your technical skills. Type 'y' when done:");
        while (true) {
            String skill = sc.nextLine();
            if (skill.equalsIgnoreCase("y")) break;
            if (!skill.trim().isEmpty()) technicalSkills.add(skill);
        }

        // Collaborative scale
        System.out.print("Rate your collaborative skills (1-5): ");
        int collabScale = 0;
        while (true) {
            try {
                collabScale = Integer.parseInt(sc.nextLine());
                if (collabScale >= 1 && collabScale <= 5) break;
            } catch (Exception e) {}
            System.out.print("Please enter a number between 1 and 5: ");
        }
        String collabFeedback = getFeedback(collabScale);

        // Field related skills, education, experience, languages
        System.out.print("Enter your field related skills: ");
        String fieldSkills = sc.nextLine();
        System.out.print("Enter your education completed: ");
        String education = sc.nextLine();
        System.out.print("Enter your work experience: ");
        String experience = sc.nextLine();
        System.out.print("Enter languages you speak (comma separated): ");
        String languages = sc.nextLine();

        // Print Resume
        System.out.println("\n===== Generated Resume =====");
        System.out.println(firstName + " " + lastName);
        System.out.println("Email: " + gmail);
        System.out.println("Phone: " + phone);
        if (!linkedin.isEmpty())
            System.out.println("LinkedIn: " + linkedin);
        System.out.println("Address: " + address + ", " + suburb + ", " + postCode);

        System.out.println("\nInterpersonal Skills:");
        for (String s : interpersonalSkills) System.out.println(" - " + s);

        System.out.println("\nTechnical Skills:");
        for (String s : technicalSkills) System.out.println(" - " + s);

        System.out.println("\nCollaborative Scale: " + collabScale + "/5");
        System.out.println("Feedback: " + collabFeedback);

        System.out.println("\nField Related Skills: " + fieldSkills);
        System.out.println("Education: " + education);
        System.out.println("Work Experience: " + experience);
        System.out.println("Languages: " + languages);

        System.out.println("\n===========================");

        sc.close();
    }
}
