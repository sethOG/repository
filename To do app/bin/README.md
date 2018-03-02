# CO2012 Worksheet 2 Sprint Timetable

| Mon | Tue | Wed | Thu | Fri | Sat | Sun |
| --- | --- | --- | --- | --- | --- | --- | 
| 13 | 14 | 15 | 16 | 17 | 18 | 19 |
| **`20`** | **`21`** | **`22`** | **`23`** | **`24`** | **`25`** | **`26`** | 
| 27 | 28 | 29 | 30 | 1 | 2 | 3 |
| 4 | 5 | 6 | 7 | **8** | 9 | 10 |

- Sprint 2 is currently highlighted
- New Sprint starts every monday
- **DEADLINE FOR WORKSHEET 2: `8th December`**

## Sprint 1 

Scrum Master: `Seth`

Project Owner: `Holly`

## Sprint 2 
  
> End date: `26th November`

Scrum Master: `Clay`

Project Owner: `Yasas`

## Sprint 3
> Start date: `27th November`
  
> End date: `3rd Decemeber`

Scrum Master: `Holly`

Project Owner: `Clay`

## Sprint 4
> Start date: `4th December`
  
> End date: `7th December`

Scrum Master: `Yasas`

Project Owner: `Seth`

# Scrum Process Guide
**ON PIVOTAL TRACKER, CHANGE VELOCITY TO 16, IT WON'T STAY SET**

For a story to be ‘done’ it must have:
- market research
- working code
- working tests
- userguide

## Market Research
Applications we will use: 
> https://web.any.do/ can be downloaded on all platforms or just use web version
                         
> https://somcloud.com/apps/todo is available on web and both apple and android phones

Write in the file called `market_research.md` that is in the documents folder

Example layout:
![Alt text](help_guide/images/market_research_file.png?raw=true "Market Research File Layout")

The # makes the following text a heading and the number of #'s refer to the headings title; # is main heading and ## is heading 2.

For each story, write '## story title'.
> For the example in the screenshoot above, the story title is "Show how many tasks are in the list" which refers to the story "user can see how many tasks are in the list"

![Alt text](help_guide/images/market_research_example.png?raw=true "Market Research Example")

Open one of the task management applications we are using and find how the app displays the information related to your story
> For this example, the app TodoTxtMac displays the number of tasks at the bottom of the screen. This is written in market_research.md along with a description of how it is displayed

Repeat this for another task management application

Once done, commit the file to GitHub. Log onto Github and find your commit you just submitted and copy the URL. Go on to [Pivotal Tracker](https://www.pivotaltracker.com/n/projects/).

![Alt text](help_guide/images/market_research_proof.png?raw=true "Adding Market Research Proof")

Select the story you are working on and paste the URL into the 'Activity' section

When the market research is done for a story and you are ready to start coding for it, press the start button

The test code needs to be written in the TaskTest.groovy file

![Alt text](help_guide/images/test_code_1.png?raw=true "Test Example")
![Alt text](help_guide/images/test_code_2.png?raw=true "Test Example")

> These two screenshots show example test code for the story "user can see how many tasks are in the list".

Once your test works, commit it to GitHub and copy and paste the commit URL into 'Activity' like before.

Do the same for your code once it works too.

Now check the code works in Travis. When the build compiles and the tests pass, get a link to the build you just performed and paste in into 'Activity' as before.

Click finish on the story.

Now edit the user_guide.md document found in /documents.

![Alt text](help_guide/images/user_guide_example.png?raw=true "User Guide Example")

Add a title for the story you are working on along with a description of what the function of the code you created is, how the user can use the function and the expected outcome of carrying out the function.

Finally commit the user guide to GitHub and paste the link in 'Activity' on Pivotal Tracker. The story will now have a complete definition of done. 

The Project Owner must now review the work to make sure everything is there. They must also run the story to make sure it works. Press Accept or Reject depending on if you are happy with the story.

Any rejected stories need to be reviewed.
