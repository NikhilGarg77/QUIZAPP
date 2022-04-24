# QuizApp
Quiz app made by sqlite and shared preferences

Group 10 QuizApp:
This quiz app is made by using shared preferences for login/register and SQLite database for questionBank. We developed this app in java language.
Functioning: 

1.)	User clicks on the app icon and home page is shown. 

 
Figure 1: Starting App
2.)	Here we used progress bar and sleep thread of 3000milsec where it seems that the app is loading. Then user is directed to login activity by using Intent functionality.
 
Figure 2: App Loading using progress bar

3.)	On the login page, there are two buttons to login or register. User is required to login to start the quiz. If user is not registered, then a toast message is displayed saying INVALID INPUT. So user has to register himself prior to login.

 
Figure 3: Login Page

 
Figure 4Validation

4.)	When user click on register button, he is directed to register activity. Here user is required to put all the information asked and if user leaves it blank, toast “enter value in all the fields” pops up.
 
Figure 5Register page
 
Figure 6validation
5.)	Here you can see that only N is written in security key, as we have restricted the user to enter more than one letter in the security key field(as per the requirement of the project)
 
Figure 7: filling values
6.)	When user fills all the data and hit register, he/she is redirected to login screen (with toast “User registered”) where after entering the correct input, user can move forward and toast “Login successful” is shown.
 
Figure 8: user registered and redirected to login screen
7.)	On the welcome screen/Main Screen, the name of the user is shown with welcome message, and there are three buttons ( start quiz, create quiz or logout) . One thing that is quite noticeable is that user is not allowed to go back and forth in questions during quiz. We created a function named onBackPressed for that purpose so that when back button is hit, all the activity is finished after conformation from user. *screen shot attached at the end….
 
Figure 9: user logged in
8.)	 On pressing start quiz, user goes to quizActivity, here score is 0 and it increases by one with each correct answer.
 
Figure 10quiz start, score zero
9.)	Here answer is correct so toast “correct” is displayed and user is moved to next question and score increases by 1.
 
Figure 11: correct answer
10.)	With the wrong answer, score remains one but user is moved to next question with toast message “Wrong”.
 
Figure 12: wrong answer
11.)	At the end, high score is counted and users score is also counted. Moreover, after the last question, toast “It was the last question” is displayed too. At this point, user has the option to restart the quiz or logout.
 
Figure 133 out of 4 questions right
12.)	If user restarts the quiz by hitting image button try again, then quiz starts again with score 0/4.
 
Figure 14: pressing repeat button, redirected to quiz screen, score 0
13.)	If user presses LOGOUT button, then he/she is redirected to login page.
 
Figure 15: pressing logout button, redirected to login activity
14.)	 On pressing Create Quiz, user is directed to a page to Add questions. Here we have 4 buttons. All with their respective functionality.
 
Figure 16: Create quiz
 
Figure 17: validation
 
Figure 18: adding question
 
Figure 19question added

 
Figure 20: preview Questions

When we click on add more then user is directed to create quiz activity to add more questions and when we click on logout then we are logged out and returned to login screen.



Extra thing in our project…
1.)	Back button functionality.. asks user if he really wants to quit the quiz??...
 
Figure 21: on pressing back button, user not allowed to move back and forth during quiz.
2.)	An inflater, it doesn’t have any course of action but we used it just to make the app look good.
 
Figure 22: menu inflater for settings, null activity

Here is our database that we used for the question bank…
 
Figure 23: database for quiz
 
Figure 24: Database for new questions.
