# CandidateManager
Problem Descriptions:
A company wants to have an application to manage their recruitment candidates and test/interview results. The project team designed the ERD as below:



Each candidate can apply for one or many positions with different respective skills such as Java, .NET, FrontEnd, Embedded, .. Therefore, the candidates may have no or many recruitment exam and interview results of them.

Bussiness rules:

Candidate entity:

fullName, dateOfBirth, graduationYear, phone, email: are not null

phone, email: are unique

gender: accepts value 0 (female) and 1 (male) only.

level: skill level of candidate (accepts value range from 1 to 7 only)

EntryTest:

languageResult, techinicalResult: accepts value range from 0 to 10 only.

result: 'pass' or 'fail' value.

Questions to answer:
The trainees need to create a new project structure to use Maven managing libraries, project name as orm.m.a301.

Creating a package with name as training.entities in this project that contain 3 above entities: Candidate, Interview, EntryTest.

You must create the appropriate DAO classes for the above models (CandidateDao, InterviewDao, EntryTestDao) to proceed CRUD and some operations as following (using HQL-a,b,c and Criteria-d,e,f)

Find all of the candidate that has skill is 'Angluar’ and skill level is 2.

Find all of the candidate that has foreign language is 'Japanese' and skill is 'Python/ML'.

Find all of the candidate by skill and entry test result (that has skill is ‘Java’ and pass entry test on '1-Oct-2020').

Find all of the candidate that pass interview on '15-Oct-2020'.

Update remark is inactive for candidates who do not have either phone, email and cv.

Create a method to proceed paging operation for Candidate use Hibernate Criteria Query Language.

Unit Testing Requirements:
You must write scripts to test all of the DAO methods that you have developed.
