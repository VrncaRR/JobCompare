=========================================================================================================
1. When the app is started, the user is presented with the main menu, which allows the
user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison
settings, or (4) compare job offers (disabled if no job offers were entered yet1).
-------------------------------------------------------------------------
- The first 3 options listed will always be available to the user. The 4th option "Compare job offers", will only be available if
the 'Comparison' attribute 'jobs[]' has 2 or more members.

- The rest of this is not represented in my design and will be handled by the GUI implementation


=========================================================================================================
2. When choosing to enter current job details, a user will:
a. Be shown a user interface to enter (if it is the first time) or edit all the details of
their current job
b. Be able to either save the job details or cancel and exit without saving, returning
in both cases to the main menu.
-------------------------------------------------------------------------
- To realize this requirement there will be a 'Comparison' class, which has an attribute, jobs. The attribute jobs will be of type 'Job[]'.
The 'Job' class will have attributes definited by the requirement(each of appropriate data type)(see UMLDesign.pdf for details) as well as a boolean value 
(isCurrentJob) indicating that a job is the users current job and values for 'adjustedSalary' and 'adjustedBonus'.

The 'Comparison' class will have an operation 'addCurrentJob' which will be called from the GUI. The user will enter required job details into data entry fields
then when the user presses the "Save" button the 'addCurrentJob' operation will create a new instance of type 'Job' with the 'Job' attribute 'isCurrentJob' as True. 
The 'Job' class will also have access to a data structure containing cost of living index data. Searching through this data structure the cost of Living attribute of 
the 'Job' class will be set based on the job City and State data.

The newly instantiated job will then be appended to the 'jobs[]' array.

The "cancel" and "exit without saving" functionality will be handled entierly within the GUI implementation.


=========================================================================================================
3. When choosing to enter job offers, a user will:
a. Be shown a user interface to enter all the details of the offer, which are the same
ones listed above for the current job.
b. Be able to either save the job offer details or cancel.
c. Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the
offer (if they saved it) with the current job details (if present).
-------------------------------------------------------------------------
- To realize this requirement the 'Comparison' class will use a custom GUI page with data entry fields for each of the user defined job attributes. When the user selects
save the job offer details, the GUI will call an 'addJobOffer' operation. This operation will create a new instance of type 'Job' using the user entries and also looking
the cost of living index and calculating the 'adjustedSalary' attribute using the 'calcAdjustedSalary' operation and the 'adjustedBonus' attribute using the
'calcAdjustedBonus' operation. Then the next job instance will be appended tothe 'jobs[]' array of the 'Comparison' class.

The "enter another offer", "cancel", "return to the main menu", or "compare the offer" functionality will be handled by the GUI implementation.


=========================================================================================================
4. When adjusting the comparison settings, the user can assign integer weights to:
-------------------------------------------------------------------------
-To realize this requirement the 'Comparison' class will have attributes for each of the defined comparison weights. The GUI will have a settings screen with data entry
fields where the user can input values for the weights. TWhen the user presses thes save button on this string it will call an 'setWeights' operation which will update
the comparison settings to the user input values.


=========================================================================================================
5. When choosing to compare job offers, a user will:
a. Be shown a list of job offers, displayed as Title and Company, ranked from best
to worst (see below for details), and including the current job (if present), clearly
indicated.
b. Select two jobs to compare and trigger the comparison.
c. Be shown a table comparing the two jobs, displaying, for each job
d. Be offered to perform another comparison or go back to the main menu.
-------------------------------------------------------------------------
- To realize this requirement, when the user navigates to the 'compare job offers' screen the GUI will call the 'sortJobs' operation. This operation will first iterate
through all of the jobs in the 'jobs[]' array and set their 'score' attributes. The score attributes are calculated using the 'Comparison' operation 'calcJobScore',
which will use the attributes of an individual job to calculate it's weighted score using the comparison settings. The 'score' attribute of each 'Job' instance will
be updated using the 'setScore' operator of the 'Job' class. After updating all of the job scores, then a simple sort algorithm will be run to arrange the 'jobs[]' 
array from highest to lowest score.

If a job attribute 'isCurrentJob' is True, that job will be displayed in bold in the list (this should only ever be 1 entry).

The operator will be able to select 2 jobs to compare. The 'Comparison' class will have an attribute 'compare1' and an attiribute 'compare2' which will correspond to
the index of the jobs selected for comparison. When the operator selects comparison the GUI will be able to reference the attributes for those selected jobs.

The navigation to 'perform another comparison' or 'go back to main menu' will be handled by the GUI implementation.


=========================================================================================================
6. When ranking jobs, a job’s score is computed as the weighted sum
-------------------------------------------------------------------------
- the 'calcJobScore' operation of the 'Comparison' class will handle the calculation and setting of the job's score. This operator will use the formula as detailed.


=========================================================================================================
7. The user interface must be intuitive and responsive.
-------------------------------------------------------------------------
- This is not represented in my design, as it will be handled entirely within the GUI implementation.


=========================================================================================================
8. For simplicity, you may assume there is a single system running the app (no
communication or saving between devices is necessary)
-------------------------------------------------------------------------
-N/A
