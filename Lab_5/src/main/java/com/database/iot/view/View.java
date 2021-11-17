package com.database.iot.view;

import com.database.iot.controller.impl.*;
import com.database.iot.model.entities.*;

import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private static final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    private final CandidateCvController candidateCvController;
    private final EnglishInterviewController englishInterviewController;
    private final TechnicalInterviewController technicalInterviewController;
    private final ComentController comentController;
    private final MarkOfInterviewController markOfInterviewController;
    private final PotentialCandidateController potentialCandidateController;
    private final ContactPersonController contactPersonController;
    private final VacancyController vacancyController;

    private final Map<String, Printable> menu = new LinkedHashMap<>();

    public View(){
        candidateCvController = new CandidateCvController();
        englishInterviewController = new EnglishInterviewController();
        technicalInterviewController = new TechnicalInterviewController();
        comentController = new ComentController();
        markOfInterviewController = new MarkOfInterviewController();
        potentialCandidateController = new PotentialCandidateController();
        contactPersonController = new ContactPersonController();
        vacancyController = new VacancyController();

        menu.put("11", this::getAllCandidateCv);
        menu.put("12", this::getCandidateCvById);
        menu.put("13", this::createCandidateCv);
        menu.put("14", this::updateCandidateCv);
        menu.put("15", this::deleteCandidateCv);

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

    public void displayMenu(){
        System.out.println("----------------------------------------------------------");

        System.out.println("  X - entity number:         |        Y - CRUD number:");
        System.out.println("  1 - Candidate CV           |        1 - GET ALL");
        System.out.println("  2 - English interview      |        2 - GET ONE");
        System.out.println("  3 - Technical interview    |        3 - CREATE");
        System.out.println("  4 - Coment                 |        4 - UPDATE");
        System.out.println("  5 - Mark of interview      |        5 - DELETE");
        System.out.println("  6 - Potential candidate    |                     ");
        System.out.println("  7 - Contact person         |                     ");
        System.out.println("  8 - Vacancy                |                     ");

        System.out.println("----------------------------------------------------------");
    }

    private void getAllCandidateCv(){
        System.out.println("\n[CandidateCv / GET]");
        System.out.println(candidateCvController.findAll() + "\n");
    }
    private void getCandidateCvById(){
        System.out.println("\n [CandidateCv / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(candidateCvController.findOne(id) + "\n");
    }
    private CandidateCv getCandidateCvInputs(){
        System.out.println("Enter job  : ");
        String job = scanner.next();
        System.out.println("Enter work experience  : ");
        String work_experience = scanner.next();
        System.out.println("Enter place of study  : ");
        String place_of_study = scanner.next();
        System.out.println("Enter hobby : ");
        String hobby = scanner.next();
        System.out.println("Enter skills : ");
        String skills = scanner.next();

        return new CandidateCv(0, job, work_experience, place_of_study, hobby, skills);
    }
    private void createCandidateCv(){
        System.out.println("\n[CandidateCv / CREATE]");
        CandidateCv candidateCv = getCandidateCvInputs();
        candidateCvController.create(candidateCv);
        System.out.println("Candidate CV successfully created\n");
    }
    private void updateCandidateCv(){
        System.out.println("\n[CandidateCv / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        CandidateCv candidateCv = getCandidateCvInputs();
        candidateCv.setId(id);
        candidateCvController.update(candidateCv.getId(), candidateCv);

        System.out.println("Candidate CV with ID = " + id + " successfully updated");
    }
    private void deleteCandidateCv(){
        System.out.println("[CandidateCv / DELETE] Enter ID: ");
        int id = scanner.nextInt();

        candidateCvController.delete(id);
        System.out.println("CandidateCv with ID = " + id + " successfully deleted");
    }


    private void getAllEnglishInterview(){
        System.out.println("\n[EnglishInterview / GET]");
        System.out.println(englishInterviewController.findAll() + "\n");
    }
    private void getEnglishInterviewById(){
        System.out.println("\n [EnglishInterview / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(englishInterviewController.findOne(id) + "\n");
    }
    private EnglishInterview getEnglishInterviewInputs(){
        System.out.println("Enter level of technical  : ");
        String level_of_technical = scanner.next();
        System.out.println("Enter level of speaking  : ");
        String level_of_speaking = scanner.next();
        System.out.println("Enter general level  : ");
        String general_level = scanner.next();

        return new EnglishInterview(0, level_of_technical, level_of_speaking, general_level);
    }
    private void createEnglishInterview(){
        System.out.println("\n[EnglishInterview / CREATE]");
        EnglishInterview englishInterview = getEnglishInterviewInputs();
        englishInterviewController.create(englishInterview);
        System.out.println("English interview successfully created\n");
    }
    private void updateEnglishInterview(){
        System.out.println("\n[EnglishInterview / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        EnglishInterview englishInterview = getEnglishInterviewInputs();
        englishInterview.setId(id);
        englishInterviewController.update(englishInterview.getId(), englishInterview);

        System.out.println("English interview with ID = " + id + " successfully updated");
    }
    private void deleteEnglishInterview(){
        System.out.println("[EnglishInterview / DELETE] Enter ID: ");
        int id = scanner.nextInt();

        englishInterviewController.delete(id);
        System.out.println("English interview with ID = " + id + " successfully deleted");
    }



    private void getAllTechnicalInterview(){
        System.out.println("\n[TechnicalInterview / GET]");
        System.out.println(technicalInterviewController.findAll() + "\n");
    }
    private void getTechnicalInterviewById(){
        System.out.println("\n [TechnicalInterview / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(technicalInterviewController.findOne(id) + "\n");
    }
    private TechnicalInterview getTechnicalInterviewInputs(){
        System.out.println("Enter programming language  : ");
        String programming_language = scanner.next();
        System.out.println("Enter algorithm  : ");
        String algorithm = scanner.next();
        System.out.println("Enter data structure  : ");
        String data_structure = scanner.next();
        System.out.println("Enter database  : ");
        String database = scanner.next();
        System.out.println("Enter result interview  : ");
        String result_interview = scanner.next();

        return new TechnicalInterview(0, programming_language, algorithm, data_structure, database,
                result_interview);
    }
    private void createTechnicalInterview(){
        System.out.println("\n[TechnicalInterview / CREATE]");
        TechnicalInterview technicalInterview = getTechnicalInterviewInputs();
        technicalInterviewController.create(technicalInterview);
        System.out.println("Technical interview successfully created\n");
    }
    private void updateTechnicalInterview(){
        System.out.println("\n[TechnicalInterview / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        TechnicalInterview technicalInterview = getTechnicalInterviewInputs();
        technicalInterview.setId(id);
        technicalInterviewController.update(technicalInterview.getId(), technicalInterview);

        System.out.println("Technical interview with ID = " + id + " successfully updated");
    }
    private void deleteTechnicalInterview(){
        System.out.println("[TechnicalInterview / DELETE] Enter ID: ");
        int id = scanner.nextInt();

        technicalInterviewController.delete(id);
        System.out.println("Technical interview with ID = " + id + " successfully deleted");
    }



    private void getAllComent(){
        System.out.println("\n[Coment / GET]");
        System.out.println(comentController.findAll() + "\n");
    }
    private void getComentById(){
        System.out.println("\n [Coment / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(comentController.findOne(id) + "\n");
    }
    private Coment getComentInputs(){
        System.out.println("Enter rating  : ");
        Integer rating = scanner.nextInt();
        System.out.println("Enter response  : ");
        String response = scanner.next();

        return new Coment(0, rating, response);
    }
    private void createComent(){
        System.out.println("\n[Coment / CREATE]");
        Coment coment = getComentInputs();
        comentController.create(coment);
        System.out.println("Coment successfully created\n");
    }
    private void updateComent(){
        System.out.println("\n[Coment / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        Coment coment = getComentInputs();
        coment.setId(id);
        comentController.update(coment.getId(), coment);

        System.out.println("Coment with ID = " + id + " successfully updated");
    }
    private void deleteComent(){
        System.out.println("[Coment / DELETE] Enter ID: ");
        int id = scanner.nextInt();

        comentController.delete(id);
        System.out.println("Coment with ID = " + id + " successfully deleted");
    }



    private void getAllMarkOfInterview(){
        System.out.println("\n[MarkOfInterview / GET]");
        System.out.println(markOfInterviewController.findAll() + "\n");
    }
    private void getMarkOfInterviewById(){
        System.out.println("\n [MarkOfInterview / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(markOfInterviewController.findOne(id) + "\n");
    }
    private MarkOfInterview getMarkOfInterviewInputs(){
        System.out.println("Enter level  : ");
        String level = scanner.next();
        System.out.println("Enter coment id  : ");
        Integer coment_id = scanner.nextInt();

        return new MarkOfInterview(0, level, coment_id);
    }
    private void createMarkOfInterview(){
        System.out.println("\n[MarkOfInterview / CREATE]");
        MarkOfInterview markOfInterview = getMarkOfInterviewInputs();
        markOfInterviewController.create(markOfInterview);
        System.out.println("Mark of interview successfully created\n");
    }
    private void updateMarkOfInterview(){
        System.out.println("\n[MarkOfInterview / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        MarkOfInterview markOfInterview = getMarkOfInterviewInputs();
        markOfInterview.setId(id);
        markOfInterviewController.update(markOfInterview.getId(), markOfInterview);

        System.out.println("Mark of interview with ID = " + id + " successfully updated");
    }
    private void deleteMarkOfInterview(){
        System.out.println("[MarkOfInterview / DELETE] Enter ID: ");
        int id = scanner.nextInt();

        markOfInterviewController.delete(id);
        System.out.println("Mark of interview with ID = " + id + " successfully deleted");
    }



    private void getAllPotentialCandidate(){
        System.out.println("\n[PotentialCandidate / GET]");
        System.out.println(potentialCandidateController.findAll() + "\n");
    }
    private void getPotentialCandidateById(){
        System.out.println("\n [PotentialCandidate / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(potentialCandidateController.findOne(id) + "\n");
    }
    private PotentialCandidate getPotentialCandidateInputs(){
        System.out.println("Enter name  : ");
        String name = scanner.next();
        System.out.println("Enter surname  : ");
        String surname = scanner.next();
        System.out.println("Enter phone number  : ");
        Integer phone_number = scanner.nextInt();
        System.out.println("Enter email  : ");
        String email = scanner.next();
        System.out.println("Enter github  : ");
        String github = scanner.next();
        System.out.println("Enter linkedin  : ");
        String linkedin = scanner.next();
        System.out.println("Enter candidate cv id  : ");
        Integer candidate_cv_id = scanner.nextInt();
        System.out.println("Enter english interview id  : ");
        Integer english_interview_id = scanner.nextInt();
        System.out.println("Enter technical interview id  : ");
        Integer technical_interview_id = scanner.nextInt();
        System.out.println("Enter mark of interview id  : ");
        Integer mark_of_interview_id = scanner.nextInt();

        return new PotentialCandidate(0, name, surname, phone_number, email, github, linkedin, candidate_cv_id,
                english_interview_id, technical_interview_id, mark_of_interview_id);
    }
    private void createPotentialCandidate(){
        System.out.println("\n[PotentialCandidate / CREATE]");
        PotentialCandidate potentialCandidate = getPotentialCandidateInputs();
        potentialCandidateController.create(potentialCandidate);
        System.out.println("Potential candidate successfully created\n");
    }
    private void updatePotentialCandidate(){
        System.out.println("\n[PotentialCandidate / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        PotentialCandidate potentialCandidate = getPotentialCandidateInputs();
        potentialCandidate.setId(id);
        potentialCandidateController.update(potentialCandidate.getId(), potentialCandidate);

        System.out.println("Potential candidate with ID = " + id + " successfully updated");
    }
    private void deletePotentialCandidate(){
        System.out.println("[PotentialCandidate / DELETE] Enter ID: ");
        int id = scanner.nextInt();

        potentialCandidateController.delete(id);
        System.out.println("Potential candidate with ID = " + id + " successfully deleted");
    }



    private void getAllContactPerson(){
        System.out.println("\n[ContactPerson / GET]");
        System.out.println(contactPersonController.findAll() + "\n");
    }
    private void getContactPersonById(){
        System.out.println("\n [ContactPerson / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(contactPersonController.findOne(id) + "\n");
    }
    private ContactPerson getContactPersonInputs(){
        System.out.println("Enter name  : ");
        String name = scanner.next();
        System.out.println("Enter surname  : ");
        String surname = scanner.next();
        System.out.println("Enter phone number  : ");
        Integer phone_number = scanner.nextInt();

        return new ContactPerson(0, name, surname, phone_number);
    }
    private void createContactPerson(){
        System.out.println("\n[ContactPerson / CREATE]");
        ContactPerson contactPerson = getContactPersonInputs();
        contactPersonController.create(contactPerson);
        System.out.println("Contact person successfully created\n");
    }
    private void updateContactPerson(){
        System.out.println("\n[ContactPerson / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        ContactPerson contactPerson = getContactPersonInputs();
        contactPerson.setId(id);
        contactPersonController.update(contactPerson.getId(), contactPerson);

        System.out.println("Contact person with ID = " + id + " successfully updated");
    }
    private void deleteContactPerson(){
        System.out.println("[ContactPerson / DELETE] Enter ID: ");
        int id = scanner.nextInt();

        contactPersonController.delete(id);
        System.out.println("Contact person with ID = " + id + " successfully deleted");
    }



    private void getAllVacancy(){
        System.out.println("\n[Vacancy / GET]");
        System.out.println(vacancyController.findAll() + "\n");
    }
    private void getVacancyById(){
        System.out.println("\n [Vacancy / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(vacancyController.findOne(id) + "\n");
    }
    private Vacancy getVacancyInputs(){
        System.out.println("Enter job desciption  : ");
        String job_desciption = scanner.next();
        System.out.println("Enter project name  : ");
        String project_name = scanner.next();

        return new Vacancy(0, job_desciption, project_name);
    }
    private void createVacancy(){
        System.out.println("\n[Vacancy / CREATE]");
        Vacancy vacancy = getVacancyInputs();
        vacancyController.create(vacancy);
        System.out.println("Vacancy successfully created\n");
    }
    private void updateVacancy(){
        System.out.println("\n[Vacancy / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        Vacancy vacancy = getVacancyInputs();
        vacancy.setId(id);
        vacancyController.update(vacancy.getId(), vacancy);

        System.out.println("Vacancy with ID = " + id + " successfully updated");
    }
    private void deleteVacancy(){
        System.out.println("[Vacancy / DELETE] Enter ID: ");
        int id = scanner.nextInt();

        vacancyController.delete(id);
        System.out.println("Vacancy with ID = " + id + " successfully deleted");
    }


    public final void show() {
        String input;
        displayMenu();
        System.out.println("\nChoose your table:\n");
        do {
            try {
                input = scanner.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (scanner.hasNext());
    }
}
