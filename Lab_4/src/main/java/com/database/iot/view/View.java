package com.database.iot.view;

import com.database.iot.controller.impl.*;
import com.database.iot.model.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.out;

public class View {
    private static final String KEY_EXIT = "Q";
    private final static Scanner scanner = new Scanner(System.in);
    private final Map<String, Printable> menu = new HashMap<>();

    private final CandidateCVController candidateCVController = new CandidateCVController();
    private final EnglishInterviewController englishInterviewController = new EnglishInterviewController();
    private final TechnicalInterviewController technicalInterviewController = new TechnicalInterviewController();
    private final ComentController comentController = new ComentController();
    private final MarkOfInterviewController markOfInterviewController = new MarkOfInterviewController();
    private final PotentialCandidateController potentialCandidateController = new PotentialCandidateController();
    private final ContactPersonController contactPersonController = new ContactPersonController();
    private final VacancyController vacancyController = new VacancyController();

    public View() {
        menu.put("11", this::getAllCandidateCV);
        menu.put("12", this::getCandidateCVById);
        menu.put("13", this::createCandidateCV);
        menu.put("14", this::updateCandidateCV);
        menu.put("15", this::deleteCandidateCV);

        menu.put("21", this::getAllEnglishInterview);
        menu.put("22", this::getEnglishInterviewById);
        menu.put("23", this::createEnglishInterview);
        menu.put("24", this::updateEnglishInterview);
        menu.put("25", this::deleteEnglishInterview);

        menu.put("31", this::getAllTechnicalInterview);
        menu.put("32", this::getTechnicalInterviewById);
        menu.put("33", this::createTechnicalInterview);
        menu.put("34", this::updateTechnicalInterview);
        menu.put("35", this::deleteTechnicalInterview);

        menu.put("41", this::getAllComent);
        menu.put("42", this::getComentById);
        menu.put("43", this::createComent);
        menu.put("44", this::updateComent);
        menu.put("45", this::deleteComent);

        menu.put("51", this::getAllMarkOfInterview);
        menu.put("52", this::getMarkOfInterviewById);
        menu.put("53", this::createMarkOfInterview);
        menu.put("54", this::updateMarkOfInterview);
        menu.put("55", this::deleteMarkOfInterview);

        menu.put("61", this::getAllPotentialCandidate);
        menu.put("62", this::getPotentialCandidateById);
        menu.put("63", this::createPotentialCandidate);
        menu.put("64", this::updatePotentialCandidate);
        menu.put("65", this::deletePotentialCandidate);

        menu.put("71", this::getAllContactPerson);
        menu.put("72", this::getContactPersonById);
        menu.put("73", this::createContactPerson);
        menu.put("74", this::updateContactPerson);
        menu.put("75", this::deleteContactPerson);

        menu.put("81", this::getAllVacancy);
        menu.put("82", this::getVacancyById);
        menu.put("83", this::createVacancy);
        menu.put("84", this::updateVacancy);
        menu.put("85", this::deleteVacancy);
    }

    private void getAllCandidateCV() throws SQLException {
        candidateCVController.findAll().forEach(out::println);
        massageItsAll();
    }

    private void getCandidateCVById() throws SQLException {
        out.println(candidateCVController.findById(getId()));
        massageItsAll();
    }

    private void createCandidateCV() throws SQLException {
        candidateCVController.create(getCandidateCVFromInput());
        massageCreated();
    }

    private void updateCandidateCV() throws SQLException {
        Integer id = getId();
        CandidateCV candidateCV = getCandidateCVFromInput();
        candidateCV.setId(id);
        candidateCVController.update(candidateCV.getId(), candidateCV);
        massageUpdate();
    }

    private void deleteCandidateCV() throws SQLException {
        candidateCVController.delete(getId());
        massageDeleted();
    }

    private CandidateCV getCandidateCVFromInput() {
        out.println("Candidate CV id: ");
        Integer candidate_cv_id = Integer.parseInt(scanner.nextLine());
        out.println("Job: ");
        String job = scanner.nextLine();
        out.println("Work experience: ");
        String work_experience = scanner.nextLine();
        out.println("Place of study: ");
        String place_of_study = scanner.nextLine();
        out.println("Hobby: ");
        String hobby = scanner.nextLine();
        out.println("Skills: ");
        String skills = scanner.nextLine();
        return new CandidateCV(candidate_cv_id, job, work_experience, place_of_study, hobby, skills);
    }


    private void getAllEnglishInterview() throws SQLException {
        englishInterviewController.findAll().forEach(out::println);
        massageItsAll();
    }

    private void getEnglishInterviewById() throws SQLException {
        out.println(englishInterviewController.findById(getId()));
        massageItsAll();
    }

    private void createEnglishInterview() throws SQLException {
        englishInterviewController.create(getEnglishInterviewFromInput());
        massageCreated();
    }

    private void updateEnglishInterview() throws SQLException {
        Integer id = getId();
        EnglishInterview englishInterview = getEnglishInterviewFromInput();
        englishInterview.setId(id);
        englishInterviewController.update(englishInterview.getId(), englishInterview);
        massageUpdate();
    }

    private void deleteEnglishInterview() throws SQLException {
        englishInterviewController.delete(getId());
        massageDeleted();
    }

    private EnglishInterview getEnglishInterviewFromInput() {
        out.println("English interview id: ");
        Integer english_interview_id = Integer.parseInt(scanner.nextLine());
        out.println("Level of technical: ");
        String level_of_technical = scanner.nextLine();
        out.println("Level of speaking: ");
        String level_of_speaking = scanner.nextLine();
        out.println("General level: ");
        String general_level = scanner.nextLine();
        return new EnglishInterview(english_interview_id, level_of_technical, level_of_speaking, general_level);
    }


    private void getAllTechnicalInterview() throws SQLException {
        technicalInterviewController.findAll().forEach(out::println);
        massageItsAll();
    }

    private void getTechnicalInterviewById() throws SQLException {
        out.println(technicalInterviewController.findById(getId()));
        massageItsAll();
    }

    private void createTechnicalInterview() throws SQLException {
        technicalInterviewController.create(getTechnicalInterviewFromInput());
        massageCreated();
    }

    private void updateTechnicalInterview() throws SQLException {
        Integer id = getId();
        TechnicalInterview technicalInterview = getTechnicalInterviewFromInput();
        technicalInterview.setId(id);
        technicalInterviewController.update(technicalInterview.getId(), technicalInterview);
        massageUpdate();
    }

    private void deleteTechnicalInterview() throws SQLException {
        technicalInterviewController.delete(getId());
        massageDeleted();
    }

    private TechnicalInterview getTechnicalInterviewFromInput() {
        out.println("Technical interview id: ");
        Integer technical_interview_id = Integer.parseInt(scanner.nextLine());
        out.println("Programming language: ");
        String programming_language = scanner.nextLine();
        out.println("Algorithm: ");
        String algorithm = scanner.nextLine();
        out.println("Data structure: ");
        String data_structure = scanner.nextLine();
        out.println("Database: ");
        String database = scanner.nextLine();
        out.println("Result interview: ");
        String result_interview = scanner.nextLine();
        return new TechnicalInterview(technical_interview_id, programming_language, algorithm, data_structure,
                database, result_interview);
    }


    private void getAllComent() throws SQLException {
        comentController.findAll().forEach(out::println);
        massageItsAll();
    }

    private void getComentById() throws SQLException {
        out.println(comentController.findById(getId()));
        massageItsAll();
    }

    private void createComent() throws SQLException {
        comentController.create(getComentFromInput());
        massageCreated();
    }

    private void updateComent() throws SQLException {
        Integer id = getId();
        Coment coment = getComentFromInput();
        coment.setId(id);
        comentController.update(coment.getId(), coment);
        massageUpdate();
    }

    private void deleteComent() throws SQLException {
        comentController.delete(getId());
        massageDeleted();
    }

    private Coment getComentFromInput() {
        out.println("Coment id: ");
        Integer coment_id = Integer.parseInt(scanner.nextLine());
        out.println("Rating: ");
        String rating = scanner.nextLine();
        out.println("Response: ");
        String response = scanner.nextLine();

        return new Coment(coment_id, rating, response);
    }


    private void getAllMarkOfInterview() throws SQLException {
        markOfInterviewController.findAll().forEach(out::println);
        massageItsAll();
    }

    private void getMarkOfInterviewById() throws SQLException {
        out.println(markOfInterviewController.findById(getId()));
        massageItsAll();
    }

    private void createMarkOfInterview() throws SQLException {
        markOfInterviewController.create(getMarkOfInterviewFromInput());
        massageCreated();
    }

    private void updateMarkOfInterview() throws SQLException {
        Integer id = getId();
        MarkOfInterview markOfInterview = getMarkOfInterviewFromInput();
        markOfInterview.setId(id);
        markOfInterviewController.update(markOfInterview.getId(), markOfInterview);
        massageUpdate();
    }

    private void deleteMarkOfInterview() throws SQLException {
        markOfInterviewController.delete(getId());
        massageDeleted();
    }

    private MarkOfInterview getMarkOfInterviewFromInput() {
        out.println("Mark of interview id: ");
        Integer mark_of_interview_id = Integer.parseInt(scanner.nextLine());
        out.println("Level: ");
        String level = scanner.nextLine();
        out.println("Coment id: ");
        Integer coment_id = Integer.parseInt(scanner.nextLine());

        return new MarkOfInterview(mark_of_interview_id, level, coment_id);
    }


    private void getAllPotentialCandidate() throws SQLException {
        potentialCandidateController.findAll().forEach(out::println);
        massageItsAll();
    }

    private void getPotentialCandidateById() throws SQLException {
        out.println(potentialCandidateController.findById(getId()));
        massageItsAll();
    }

    private void createPotentialCandidate() throws SQLException {
        potentialCandidateController.create(getPotentialCandidateFromInput());
        massageCreated();
    }

    private void updatePotentialCandidate() throws SQLException {
        Integer id = getId();
        PotentialCandidate potentialCandidate = getPotentialCandidateFromInput();
        potentialCandidate.setId(id);
        potentialCandidateController.update(potentialCandidate.getId(), potentialCandidate);
        massageUpdate();
    }

    private void deletePotentialCandidate() throws SQLException {
        potentialCandidateController.delete(getId());
        massageDeleted();
    }

    private PotentialCandidate getPotentialCandidateFromInput() {
        out.println("Potential candidate id: ");
        Integer potential_candidate_id = Integer.parseInt(scanner.nextLine());
        out.println("Name: ");
        String name = scanner.nextLine();
        out.println("Surname: ");
        String surname = scanner.nextLine();
        out.println("Phone number: ");
        Integer phone_number = Integer.parseInt(scanner.nextLine());
        out.println("Email: ");
        String email = scanner.nextLine();
        out.println("GitHub: ");
        String github = scanner.nextLine();
        out.println("Linkedin: ");
        String linkedin = scanner.nextLine();
        out.println("Candidate CV id: ");
        Integer candidate_cv_id = Integer.parseInt(scanner.nextLine());
        out.println("English interview id: ");
        Integer english_interview_id = Integer.parseInt(scanner.nextLine());
        out.println("Technical interview id: ");
        Integer technical_interview_id = Integer.parseInt(scanner.nextLine());
        out.println("Mark of interview id: ");
        Integer mark_of_interview_id = Integer.parseInt(scanner.nextLine());

        return new PotentialCandidate(potential_candidate_id, name, surname, phone_number, email, github, linkedin,
                candidate_cv_id, english_interview_id, technical_interview_id, mark_of_interview_id);
    }



    private void getAllContactPerson() throws SQLException {
        contactPersonController.findAll().forEach(out::println);
        massageItsAll();
    }

    private void getContactPersonById() throws SQLException {
        out.println(contactPersonController.findById(getId()));
        massageItsAll();
    }

    private void createContactPerson() throws SQLException {
        contactPersonController.create(getContactPersonFromInput());
        massageCreated();
    }

    private void updateContactPerson() throws SQLException {
        Integer id = getId();
        ContactPerson contactPerson = getContactPersonFromInput();
        contactPerson.setId(id);
        contactPersonController.update(contactPerson.getId(), contactPerson);
        massageUpdate();
    }

    private void deleteContactPerson() throws SQLException {
        contactPersonController.delete(getId());
        massageDeleted();
    }

    private ContactPerson getContactPersonFromInput() {
        out.println("Contact person id: ");
        Integer contact_person_id = Integer.parseInt(scanner.nextLine());
        out.println("Name: ");
        String name = scanner.nextLine();
        out.println("Surname: ");
        String surname = scanner.nextLine();
        out.println("Phone number: ");
        Integer phone_number = Integer.parseInt(scanner.nextLine());
        return new ContactPerson(contact_person_id, name, surname, phone_number);
    }


    private void getAllVacancy() throws SQLException {
        vacancyController.findAll().forEach(out::println);
        massageItsAll();
    }

    private void getVacancyById() throws SQLException {
        out.println(vacancyController.findById(getId()));
        massageItsAll();
    }

    private void createVacancy() throws SQLException {
        vacancyController.create(getVacancyFromInput());
        massageCreated();
    }

    private void updateVacancy() throws SQLException {
        Integer id = getId();
        Vacancy vacancy = getVacancyFromInput();
        vacancy.setId(id);
        vacancyController.update(vacancy.getId(), vacancy);
        massageUpdate();
    }

    private void deleteVacancy() throws SQLException {
        vacancyController.delete(getId());
        massageDeleted();
    }

    private Vacancy getVacancyFromInput() {
        out.println("Vacancy id: ");
        Integer vacancy_id = Integer.parseInt(scanner.nextLine());
        out.println("Job desciption: ");
        String job_desciption = scanner.nextLine();
        out.println("Project name: ");
        String project_name = scanner.nextLine();
        return new Vacancy(vacancy_id, job_desciption, project_name);
    }


    private Integer getId() {
        out.println("Id:");
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

    private void massageItsAll() {
        out.println("----------------------------------------\n"
                + "That's all!\n"
                + "----------------------------------------\n" + "Select a table and action: ");
    }

    private void massageDeleted() {
        out.println("Deleted!\n" + "----------------------------------------\n" + "Select a table and action: ");
    }

    private void massageCreated() {
        out.println("Created!\n" + "----------------------------------------\n" + "Select a table and action: ");
    }

    private void massageUpdate() {
        out.println("Update!\n" + "----------------------------------------\n" + "Select a table and action: ");
    }

    private static void displayMenu() {
        out.println(
                "|--------------------------------------|---------------|\n" +
                        "| 1: candidate_cv                      |   1: GET ALL  |\n" +
                        "| 2: english_interview                 |   2: GET      |\n" +
                        "| 3: technical_interview               |   3: CREATE   |\n" +
                        "| 4: coment                            |   4: UPDATE   |\n" +
                        "| 5: mark_of_interview                 |   5: DELETE   |\n" +
                        "| 6: potential_candidate               |_______________|\n" +
                        "| 7: contact_person                    |               |\n" +
                        "| 8: vacancy                           |               |\n" +
                        "|                                      |   Q - exit    |\n" +
                        "|--------------------------------------|---------------|\n"
        );
    }

    public void show() throws SQLException {
        displayMenu();
        out.println("Select a table and action: ");
        String input = scanner.nextLine();

        while (!input.equals(KEY_EXIT)) {
            out.println("----------------------------------------");
            menu.get(input).print();
            input = scanner.nextLine();
        }
    }



}
