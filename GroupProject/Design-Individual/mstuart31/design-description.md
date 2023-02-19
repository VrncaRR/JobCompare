##Requirements
1. When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet). 
>To realize this requirement, I created a jobComparisonManager class that uses the jobComparator class to add/edit current job details, add job offers, adjust comparison settings, and/or compare job offers.
2. When choosing to enter current job details, a user will:
   
    a. Be shown a user interface to enter (if it is the first time) or edit all the details of their current job, which consist of:

    * Title
    * Company
    * Location (entered as city and state)
    * Cost of living in the location (expressed as an index)
    * Yearly salary
    * Yearly bonus
    * Restricted Stock Unit Award (expressed as a lump sum vested over 4 years)
    * Relocation stipend (A single value from $0 to $25,000)
    * Personal Choice Holidays (A single overall number of days from 0 to 20)

    b. Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.
>To realize this requirement, the job class has the aforementioned attributes (Title, Company, etc.) For the most flexibility, I chose float types for all monetary attributes. Since the jobComparisonManager class uses the job class, the user will be able to add or edit the details of their current job. The UI is intended to be handled in the GUI implementation, which is not included in the class diagram.
3. When choosing to enter job offers, a user will:
   
    a. Be shown a user interface to enter all the details of the offer, which are the same ones listed above for the current job.
   
    b. Be able to either save the job offer details or cancel.
   
    c. Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).
>To realize this requirement, the jobOffer class extends the job class. They have the same attributes, and the jobComparator class consists of jobOffer objects. After saving the job offer details or canceling, the UI is to show the options to perform any of the actions in (3c). However, the UI is not included in this design, since it will be handled in the GUI implementation.
   
4. When adjusting the comparison settings, the user can assign integer weights to:
* Yearly salary
* Yearly bonus
* Restricted Stock Unit Award 
* Relocation stipend 
* Personal Choice Holidays 
If no weights are assigned, all factors are considered equal.
>The possible integer weights are represented as attributes in the comparisonSettings class, which is used by the jobComparator class. Factors such as the user only being able to assign integers (rather than floats or String objects) will be handled in the frontend logic and as such are not represented in this design.

5. When choosing to compare job offers, a user will:

    a. Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.
       
    b. Select two jobs to compare and trigger the comparison.
    
    c. Be shown a table comparing the two jobs, displaying, for each job:

* Title
* Company
* Yearly salary adjusted for cost of living
* Yearly bonus adjusted for cost of living
* Restricted Stock Unit Award
* Relocation stipend
* Personal Choice Holidays
  
    d. Be offered to perform another comparison or go back to the main menu.
>The user can compare job offers via the compareJobOffers() method, which is a method for the jobComparisonManager class. At present, I intend to hook into a database, which will perform the relevant computation and sorting operations. The option to select jobs and display of the job comparison table will be part of the UI and are not included in this design as they will be included in the GUI implementation.

6. When ranking jobs, a job’s score is computed as the weighted sum of:

AYS + AYB + (RSUA / 4) + RELO + (PCH * AYS / 260)

where:
AYS = yearly salary adjusted for cost of living
AYB = yearly bonus adjusted for cost of living
RSU = restricted stock unit award
RELO = relocation stipend
PCH = personal choice holidays



For example, if the weights are 2 for the yearly salary, 2 for relocation stipend and 1 for all other factors, the score would be computed as:

2/7 * AYS + 1/7 * AYB + 1/7 * (RSUA / 4) + 2/7 * RELO + 1/7 * (PCH * AYS / 260)
>The jobComparator class has a computeJobScore method and can only be triggered when the user chooses to compare job offers. The variables in the job score equation are represented as attributes in the comparisonSettings class. The actual computation will be performed by a database, which is not represented in this design.
7. The user interface must be intuitive and responsive.
>The UI will be handled by the GUI implementation and accordingly is not represented in this design.
8. For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).
>My design reflects this assumption.