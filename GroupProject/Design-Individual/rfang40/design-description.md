1. When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet). 

(1) Enter or edit current job details: entering part will be handled by GUI implementation. But ser can edit the current job detail by using the setter method within the Offer class. e,g.: setTitle()

(2) Enter new job offers: can be achieved by initlizing a new Offer object and using the setter methods within the Offer class to set parameters. e,g.: setTitle()
(3) Adjust the comparison settings: can be achieved by using setter methods in the Comparison class. e.g.: setYearlySalaryWeight().
(4) Compare offers: can be achieved by using compareOffer() method in the Comparison class.

2. When choosing to enter current job details, a user will:
Be shown a user interface to enter (if it is the first time) or edit all the details of their current job, which consist of:
Title
Company
Location (entered as city and state)
Cost of living in the location (expressed as an index)
Yearly salary
Yearly bonus
Restricted Stock Unit Award (expressed as a lump sum vested over 4 years)
Relocation stipend (A single value from $0 to $25,000)
Personal Choice Holidays (A single overall number of days from 0 to 20)

Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.

This can be achieved by using the setter methods within the Offer class to set job details for the current job, which the is Offer object with isCurrentJob is true.  

3. When choosing to enter job offers, a user will:
Be shown a user interface to enter all the details of the offer, which are the same ones listed above for the current job.
Be able to either save the job offer details or cancel.
Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).

This can be achieved by initializing a new Offer object and using the setter methods within the Offer class to set offer details

(1) Entering another offer: Use GUI implementation to direct to the entering new job offer interface, which is not represented in my design. Once directed,  initialize a new Offer object and use the setter methods within the Offer class to set offer details

(2) return to the main menu: Not represented in the design

(3) compare the offer (if they saved it) with the current job details (if present): use comapreOffer() method in Comparison class to compare it with current job


4. When adjusting the comparison settings, the user can assign integer weights to:
Yearly salary
Yearly bonus
Restricted Stock Unit Award 
Relocation stipend 
Personal Choice Holidays 
If no weights are assigned, all factors are considered equal.

This can be achieved by using the setter methods in Comparison class. e.g.: setYearlySalaryWeight(). If no weights are assigned, all factors are considered equal: the default weights are set to be 1 respectively 


5. When choosing to compare job offers, a user will:
Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.
Select two jobs to compare and trigger the comparison.
Be shown a table comparing the two jobs, displaying, for each job:
Title
Company
Location 
Yearly salary adjusted for cost of living
Yearly bonus adjusted for cost of living
Restricted Stock Unit Award 
Relocation stipend 
Personal Choice Holidays 
Be offered to perform another comparison or go back to the main menu.

This can be achieved by first calling compareOffer() method in the Comparison class. And Yearly salary adjusted for cost of living, Yearly bonus adjusted for cost of living those two parameters can be calculated by using calculateSalaryAdjusted() and calculateBounsAdjusted() mthods in Offer class



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

This can be achieved by first using calculateOfferScore() in Comparison class. The method will return a Score object, where the calculated job score is an attribute. Then Comparison class uses rankOfferBasedOnScore() to rank offers based on the score in the Score object

7. The user interface must be intuitive and responsive.
This is not represented in my design, as it will be handled entirely within the GUI implementation.


8. For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).
This is not represented in my design, as it will be handled entirely within the GUI implementation.
