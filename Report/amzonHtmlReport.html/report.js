$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/ELCOT/eclipse-workspace/Amazon/src/test/java/com/feature/Amazon.feature");
formatter.feature({
  "name": "Customer Find The Right Product",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "HomePage",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "user Launch The Application Url",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.user_Launch_The_Application_Url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user Select The Category From DropDown",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.user_Select_The_Category_From_DropDown()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user Search The Product In Search Box",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.user_Search_The_Product_In_Search_Box()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user Click The Right Suggetion For The Requirement",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.user_Click_The_Right_Suggetion_For_The_Requirement()"
});
formatter.result({
  "status": "passed"
});
});