# Design Description

## When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet). 

The first 3 options listed will always be available to the user. The 4th option "Compare job offers", will only be available if two or more jobs have been entered

The rest of this is not represented in my design and will be handled by the GUI implementation

##When choosing to enter current job details, a user will:
Be shown a user interface to enter (if it is the first time) or edit all the details of their current job, which consist of: [...]
Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.

The UI will have a screen for entering a current job. The software will have a ‘Job’ class for saving the job information. The 'Job' class will have attributes defined by the requirement(each of appropriate data type)(see UMLDesign.pdf for details) as well as a boolean value ‘isCurrentJob’ indicating that a job is the users current job and values for ‘yearlySarlaryAdjusted’ an ‘yearlyBonusAdjusted’. When entering a current job the ‘isCurrentJob’ attribute will be set to true using the setCurrentJob() operation. To edit the current job the UI will call the setValue() method which will can change the value of a ‘Job’ class’ attributes.

The "cancel" and "exit without saving" functionality will be handled entierly within the GUI implementation.

When choosing to enter job offers, a user will:
Be shown a user interface to enter all the details of the offer, which are the same ones listed above for the current job.
Be able to either save the job offer details or cancel.
Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).
The job offers details will be saved as a ‘Job’ class instance. The ‘isCurrentOffer’ attribute will be set to false. There will be a button for save which will crate a new instance of the job class with attributes set to the indeed job information, the new ‘Job’ instance will be saved in a database with along with any other offers. There will also be a cancel button, when the user presses this button it will clear all of the entry fields and none of the data will be saved.

The UI will have a screen for entering all of the defined job information. The UI information will have buttons to allow for entering another offer, returning to the main menu or comparing the offer they currently have. 


When adjusting the comparison settings, the user can assign integer weights to: Veronica
Yearly salary 
Yearly bonus
Restricted Stock Unit Award 
Relocation stipend 
Personal Choice Holidays 
If no weights are assigned, all factors are considered equal.

The ComparisonSettings class can be used to implement comparison. ComparisonSettings class has attributes yearlySalaryWeight, yearlyBonusWeight, restrictedStockUnitWeight, relacationStipendWeight, and personalChoiceHolidaysWeight, with their default values setting to 1.
The UI will have a screen for entering the weights of comparison settings, and the assignment will be handled by the setWeight() method. 

When choosing to compare job offers, a user will:
Margaret
Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.
We added ‘title’ and ‘company’ (both are String types) to the job class to represent the title and company associated with a specific job or job offer. These values are entered by the setValue() method of the job class. The ranking of job offers from best to worst is performed by the rankJobBasedOnScore() method of the comparisonSettings class. The ranked list of job offers is displayed to the user in the GUI.
The score for a job offer is represented by a float ‘score’, and is calculated in the calculateScore() method of the job class. When a job offer is first created, the weights used in calculating the job offer’s score are all considered equal. If a user wishes to assign weights to a job offer, this is done independently of creating the job offer itself. Weights are entered individually with the setWeight() method of the comparisonSettings class.
Select two jobs to compare and trigger the comparison.
Prompts for selecting two jobs for comparison are handled entirely within the GUI, and as such are not represented in our design. The compareJobs() method in the comparisonSettings class is responsible for retrieving the specific job offers selected by the user.
Be shown a table comparing the two jobs, displaying, for each job:
Title
Company
Location 
Yearly salary adjusted for cost of living
Yearly bonus adjusted for cost of living
Restricted Stock Unit Award 
Relocation stipend 
Personal Choice Holidays 
The compareJob() method of the comparisonSettings class is responsible for retrieving the specific job offers the user wishes to compare. The GUI is entirely responsible for displaying the table comparing the two jobs and their attributes (title, company, yearlySalaryAdjusted, yearlyBonusAdjusted, restrictedStockUnit, relocationStipend, and personalChoiceHolidays), and accordingly is not represented in our design. The majority of these attributes for a job offer (‘title’, ‘company’, ‘location’, ‘restrictedStockUnit’, ‘relocationStipend’, and ‘personalChoiceHolidays’) are entered by the user when entering a job offer. We added the float ‘yearlySalaryAdjusted’ to represent the salary of a job offer, adjusted for cost of living in the job offer’s location. The float ‘yearlyBonusAdjusted’ serves the same purpose, but for bonus data.
Be offered to perform another comparison or go back to the main menu.
This functionality will be handled entirely within the GUI and is therefore not represented in our design.

When ranking jobs, a job’s score is computed as the weighted sum of:
Margaret
AYS + AYB + (RSUA / 4) + RELO + (PCH * AYS / 260)

where:
AYS = yearly salary adjusted for cost of living
AYB = yearly bonus adjusted for cost of living
RSU = restricted stock unit award
RELO = relocation stipend
PCH = personal choice holidays

For example, if the weights are 2 for the yearly salary, 2 for relocation stipend and 1 for all other factors, the score would be computed as:

2/7 * AYS + 1/7 * AYB + 1/7 * (RSUA / 4) + 2/7 * RELO + 1/7 * (PCH * AYS / 260)

A job’s score is computed according to the weighted sum as shown in (2). The score is computed through the calculateScore() method of the job class. The score is always calculated when a job is first created (with the assumption that all weights are equal), but it can be re-calculated if a user modifies any attribute in comparisonSettings via the setWeight() method. Certain inputs to the formula (restrictedStockUnit, relocationStipend, and personalChoiceHolidays) are inputted by the user upon creation of specific job offer. The remaining inputs (AYS and AYB, represented as the floats ‘yearlySalaryAdjusted’ and ‘yearlyBonusAdjusted’, respectively) are calculated with the calculateSalaryAdjusted() and calculateBonusAdjusted() methods of the job class. These variables represent the salary and bonus after a cost of living adjustment is applied. calculateSalaryAdjusted() and calculateBonusAdjusted() are run when a job is first entered, and the location used for each method is the location specified by the user when entering the job.

The user interface must be intuitive and responsive.
This is not represented in my design, as it will be handled entirely within the GUI implementation.
For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).
This is not represented in my design, as it will be handled entirely within the GUI implementation.
