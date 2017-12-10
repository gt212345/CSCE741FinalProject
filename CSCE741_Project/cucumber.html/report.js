$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("angular.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 20,
  "name": "Angular behavior",
  "description": "\nI want to tes the angular UI behavior",
  "id": "angular-behavior",
  "keyword": "Feature",
  "tags": [
    {
      "line": 19,
      "name": "@angular"
    }
  ]
});
formatter.scenarioOutline({
  "line": 25,
  "name": "Test login",
  "description": "",
  "id": "angular-behavior;test-login",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 24,
      "name": "@angular"
    }
  ]
});
formatter.step({
  "line": 26,
  "name": "I want log in to the system",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "I am on the home page",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "I try to log in with \u003cusername\u003e and \u003cpassword\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "The system return correct page with url \u003curl\u003e",
  "keyword": "And "
});
formatter.examples({
  "line": 31,
  "name": "",
  "description": "",
  "id": "angular-behavior;test-login;",
  "rows": [
    {
      "cells": [
        "username",
        "password",
        "url"
      ],
      "line": 32,
      "id": "angular-behavior;test-login;;1"
    },
    {
      "cells": [
        "\"admin\"",
        "\"admin\"",
        "\"http://localhost:4200/dashboard\""
      ],
      "line": 33,
      "id": "angular-behavior;test-login;;2"
    },
    {
      "cells": [
        "\"abd\"",
        "\"abd\"",
        "\"http://localhost:4200/dashboard\""
      ],
      "line": 34,
      "id": "angular-behavior;test-login;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 108493,
  "status": "passed"
});
formatter.scenario({
  "line": 33,
  "name": "Test login",
  "description": "",
  "id": "angular-behavior;test-login;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@angular"
    }
  ]
});
formatter.step({
  "line": 26,
  "name": "I want log in to the system",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "I am on the home page",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "I try to log in with \"admin\" and \"admin\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "The system return correct page with url \"http://localhost:4200/dashboard\"",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.match({
  "location": "CucumberTest.i_want_log_in_to_the_system()"
});
formatter.result({
  "duration": 7621198539,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.i_am_on_the_home_page()"
});
formatter.result({
  "duration": 864555724,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "admin",
      "offset": 22
    },
    {
      "val": "admin",
      "offset": 34
    }
  ],
  "location": "CucumberTest.i_try_to_log_in_with_admin_and_admin(String,String)"
});
formatter.result({
  "duration": 464523254,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "http://localhost:4200/dashboard",
      "offset": 41
    }
  ],
  "location": "CucumberTest.the_system_return_correct_page_with_url(String)"
});
formatter.result({
  "duration": 19245453,
  "status": "passed"
});
formatter.before({
  "duration": 31059,
  "status": "passed"
});
formatter.scenario({
  "line": 34,
  "name": "Test login",
  "description": "",
  "id": "angular-behavior;test-login;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@angular"
    }
  ]
});
formatter.step({
  "line": 26,
  "name": "I want log in to the system",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "I am on the home page",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "I try to log in with \"abd\" and \"abd\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "The system return correct page with url \"http://localhost:4200/dashboard\"",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.match({
  "location": "CucumberTest.i_want_log_in_to_the_system()"
});
formatter.result({
  "duration": 1730789654,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.i_am_on_the_home_page()"
});
formatter.result({
  "duration": 1018189306,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "abd",
      "offset": 22
    },
    {
      "val": "abd",
      "offset": 32
    }
  ],
  "location": "CucumberTest.i_try_to_log_in_with_admin_and_admin(String,String)"
});
formatter.result({
  "duration": 461763778,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "http://localhost:4200/dashboard",
      "offset": 41
    }
  ],
  "location": "CucumberTest.the_system_return_correct_page_with_url(String)"
});
formatter.result({
  "duration": 233087773,
  "error_message": "java.lang.AssertionError\n\tat org.junit.Assert.fail(Assert.java:86)\n\tat org.junit.Assert.fail(Assert.java:95)\n\tat com.usc.cucumber.CucumberTest.the_system_return_correct_page_with_url(CucumberTest.java:141)\n\tat ✽.And The system return correct page with url \"http://localhost:4200/dashboard\"(angular.feature:29)\n",
  "status": "failed"
});
formatter.uri("url.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: heiru@email.sc.edu"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 20,
  "name": "Get url content",
  "description": "\r\nAs a user of the system, I should be able to get the content of all provided url",
  "id": "get-url-content",
  "keyword": "Feature",
  "tags": [
    {
      "line": 19,
      "name": "@url"
    }
  ]
});
formatter.scenarioOutline({
  "line": 25,
  "name": "Successful get all department information",
  "description": "",
  "id": "get-url-content;successful-get-all-department-information",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 24,
      "name": "@url"
    }
  ]
});
formatter.step({
  "line": 26,
  "name": "User is on homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "User click the get all department button",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "webpage display correct department information \u003cvalue\u003e",
  "keyword": "Then "
});
formatter.examples({
  "line": 30,
  "name": "",
  "description": "",
  "id": "get-url-content;successful-get-all-department-information;",
  "rows": [
    {
      "cells": [
        "value"
      ],
      "line": 31,
      "id": "get-url-content;successful-get-all-department-information;;1"
    },
    {
      "cells": [
        "[\"EMCH\",\"ELCT\",\"MATH\",\"CSCE\",\"ECHE\",\"ECIV\",\"BMEN\"]"
      ],
      "line": 32,
      "id": "get-url-content;successful-get-all-department-information;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 36502,
  "status": "passed"
});
formatter.scenario({
  "line": 32,
  "name": "Successful get all department information",
  "description": "",
  "id": "get-url-content;successful-get-all-department-information;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@url"
    }
  ]
});
formatter.step({
  "line": 26,
  "name": "User is on homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "User click the get all department button",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "webpage display correct department information [\"EMCH\",\"ELCT\",\"MATH\",\"CSCE\",\"ECHE\",\"ECIV\",\"BMEN\"]",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "CucumberTest.user_is_on_homepage()"
});
formatter.result({
  "duration": 2798476153,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.user_click_the_get_all_department_button()"
});
formatter.result({
  "duration": 625081348,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "EMCH",
      "offset": 49
    },
    {
      "val": "ELCT",
      "offset": 56
    },
    {
      "val": "MATH",
      "offset": 63
    },
    {
      "val": "CSCE",
      "offset": 70
    },
    {
      "val": "ECHE",
      "offset": 77
    },
    {
      "val": "ECIV",
      "offset": 84
    },
    {
      "val": "BMEN",
      "offset": 91
    }
  ],
  "location": "CucumberTest.webpage_display_correct_department_information(String,String,String,String,String,String,String)"
});
formatter.result({
  "duration": 273134897,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 35,
  "name": "Successful get all instructor in CSCE department",
  "description": "",
  "id": "get-url-content;successful-get-all-instructor-in-csce-department",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 34,
      "name": "@url"
    }
  ]
});
formatter.step({
  "line": 36,
  "name": "User is on homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 37,
  "name": "User click the get all instructor for a specfic department button",
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "The system ask for department input \u003cinput\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "webpage display correct instructor information \u003cvalue\u003e",
  "keyword": "And "
});
formatter.examples({
  "line": 41,
  "name": "",
  "description": "",
  "id": "get-url-content;successful-get-all-instructor-in-csce-department;",
  "rows": [
    {
      "cells": [
        "input",
        "value"
      ],
      "line": 42,
      "id": "get-url-content;successful-get-all-instructor-in-csce-department;;1"
    },
    {
      "cells": [
        "\"CSCE\"",
        "[\"Jeremiah Jeffrey Shepherd\",\"James Paul O\u0027Reilly\",\"Marco Valtorta\",\"Mingxiang Zhu\",\"Christine M.G. Brown\",\"Jianjun Hu\",\"Chin-Tser Huang\",\"Ivelisse Ortiz-Hernandez\",\"Jeremy Shane Lewis\",\"Song Wang\",\"Dazhou Guo\",\"Patrick B. O\u0027Keefe\",\"Duncan A. Buell\",\"Homayoun Valafar\",\"Casey Anne Cole\",\"Ioannis M Rekleitis\",\"Alberto Quattrini Li\",\"Stephen A. Fenner\",\"Srihari Nelakuditi\",\"Jason Daniel Bakos\",\"Manton M. Matthews\",\"Veronica L. Wilkinson\",\"Csilla Farkas\",\"John R. Rose\",\"Gregory James Gay\",\"Jason Matthew Okane\",\"TBA\"]"
      ],
      "line": 43,
      "id": "get-url-content;successful-get-all-instructor-in-csce-department;;2"
    },
    {
      "cells": [
        "\"ECHE\"",
        "[\"William Earl Mustain\",\"Ahmed Shehab Khan\",\"Michael A. Matthews\",\"Jeremy Shane Lewis\",\"Xiao-Dong Zhou\",\"Andreas Heyden\",\"Vincent Van Brunt\",\"James A. Ritter\",\"Bihter Padak\",\"Branko N. Popov\",\"Ralph E. White\",\"Mark Jacob Uline\",\"James Otto Blanchette\",\"TBA\"]"
      ],
      "line": 44,
      "id": "get-url-content;successful-get-all-instructor-in-csce-department;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 32639,
  "status": "passed"
});
formatter.scenario({
  "line": 43,
  "name": "Successful get all instructor in CSCE department",
  "description": "",
  "id": "get-url-content;successful-get-all-instructor-in-csce-department;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@url"
    }
  ]
});
formatter.step({
  "line": 36,
  "name": "User is on homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 37,
  "name": "User click the get all instructor for a specfic department button",
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "The system ask for department input \"CSCE\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "webpage display correct instructor information [\"Jeremiah Jeffrey Shepherd\",\"James Paul O\u0027Reilly\",\"Marco Valtorta\",\"Mingxiang Zhu\",\"Christine M.G. Brown\",\"Jianjun Hu\",\"Chin-Tser Huang\",\"Ivelisse Ortiz-Hernandez\",\"Jeremy Shane Lewis\",\"Song Wang\",\"Dazhou Guo\",\"Patrick B. O\u0027Keefe\",\"Duncan A. Buell\",\"Homayoun Valafar\",\"Casey Anne Cole\",\"Ioannis M Rekleitis\",\"Alberto Quattrini Li\",\"Stephen A. Fenner\",\"Srihari Nelakuditi\",\"Jason Daniel Bakos\",\"Manton M. Matthews\",\"Veronica L. Wilkinson\",\"Csilla Farkas\",\"John R. Rose\",\"Gregory James Gay\",\"Jason Matthew Okane\",\"TBA\"]",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.match({
  "location": "CucumberTest.user_is_on_homepage()"
});
formatter.result({
  "duration": 2585064757,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.user_click_the_get_all_instructor_for_a_specfic_department_button()"
});
formatter.result({
  "duration": 40752,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "CSCE",
      "offset": 37
    }
  ],
  "location": "CucumberTest.the_system_ask_for_department_input(String)"
});
formatter.result({
  "duration": 221674592,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Jeremiah Jeffrey Shepherd",
      "offset": 49
    },
    {
      "val": "James Paul O\u0027Reilly",
      "offset": 77
    },
    {
      "val": "Marco Valtorta",
      "offset": 99
    },
    {
      "val": "Mingxiang Zhu",
      "offset": 116
    },
    {
      "val": "Christine M.G. Brown",
      "offset": 132
    },
    {
      "val": "Jianjun Hu",
      "offset": 155
    },
    {
      "val": "Chin-Tser Huang",
      "offset": 168
    },
    {
      "val": "Ivelisse Ortiz-Hernandez",
      "offset": 186
    },
    {
      "val": "Jeremy Shane Lewis",
      "offset": 213
    },
    {
      "val": "Song Wang",
      "offset": 234
    },
    {
      "val": "Dazhou Guo",
      "offset": 246
    },
    {
      "val": "Patrick B. O\u0027Keefe",
      "offset": 259
    },
    {
      "val": "Duncan A. Buell",
      "offset": 280
    },
    {
      "val": "Homayoun Valafar",
      "offset": 298
    },
    {
      "val": "Casey Anne Cole",
      "offset": 317
    },
    {
      "val": "Ioannis M Rekleitis",
      "offset": 335
    },
    {
      "val": "Alberto Quattrini Li",
      "offset": 357
    },
    {
      "val": "Stephen A. Fenner",
      "offset": 380
    },
    {
      "val": "Srihari Nelakuditi",
      "offset": 400
    },
    {
      "val": "Jason Daniel Bakos",
      "offset": 421
    },
    {
      "val": "Manton M. Matthews",
      "offset": 442
    },
    {
      "val": "Veronica L. Wilkinson",
      "offset": 463
    },
    {
      "val": "Csilla Farkas",
      "offset": 487
    },
    {
      "val": "John R. Rose",
      "offset": 503
    },
    {
      "val": "Gregory James Gay",
      "offset": 518
    },
    {
      "val": "Jason Matthew Okane",
      "offset": 538
    },
    {
      "val": "TBA",
      "offset": 560
    }
  ],
  "location": "CucumberTest.webpage_display_correct_instructor_information(String,String,String,String,String,String,String,String,String,String,String,String,String,String,String,String,String,String,String,String,String,String,String,String,String,String,String)"
});
formatter.result({
  "duration": 276101666,
  "status": "passed"
});
formatter.before({
  "duration": 29939,
  "status": "passed"
});
formatter.scenario({
  "line": 44,
  "name": "Successful get all instructor in CSCE department",
  "description": "",
  "id": "get-url-content;successful-get-all-instructor-in-csce-department;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@url"
    }
  ]
});
formatter.step({
  "line": 36,
  "name": "User is on homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 37,
  "name": "User click the get all instructor for a specfic department button",
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "The system ask for department input \"ECHE\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "webpage display correct instructor information [\"William Earl Mustain\",\"Ahmed Shehab Khan\",\"Michael A. Matthews\",\"Jeremy Shane Lewis\",\"Xiao-Dong Zhou\",\"Andreas Heyden\",\"Vincent Van Brunt\",\"James A. Ritter\",\"Bihter Padak\",\"Branko N. Popov\",\"Ralph E. White\",\"Mark Jacob Uline\",\"James Otto Blanchette\",\"TBA\"]",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.match({
  "location": "CucumberTest.user_is_on_homepage()"
});
formatter.result({
  "duration": 2479445812,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.user_click_the_get_all_instructor_for_a_specfic_department_button()"
});
formatter.result({
  "duration": 39338,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ECHE",
      "offset": 37
    }
  ],
  "location": "CucumberTest.the_system_ask_for_department_input(String)"
});
formatter.result({
  "duration": 193612248,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "William Earl Mustain",
      "offset": 49
    },
    {
      "val": "Ahmed Shehab Khan",
      "offset": 72
    },
    {
      "val": "Michael A. Matthews",
      "offset": 92
    },
    {
      "val": "Jeremy Shane Lewis",
      "offset": 114
    },
    {
      "val": "Xiao-Dong Zhou",
      "offset": 135
    },
    {
      "val": "Andreas Heyden",
      "offset": 152
    },
    {
      "val": "Vincent Van Brunt",
      "offset": 169
    },
    {
      "val": "James A. Ritter",
      "offset": 189
    },
    {
      "val": "Bihter Padak",
      "offset": 207
    },
    {
      "val": "Branko N. Popov",
      "offset": 222
    },
    {
      "val": "Ralph E. White",
      "offset": 240
    },
    {
      "val": "Mark Jacob Uline",
      "offset": 257
    },
    {
      "val": "James Otto Blanchette",
      "offset": 276
    },
    {
      "val": "TBA",
      "offset": 300
    }
  ],
  "location": "CucumberTest.webpage_display_correct_instructor_information(String,String,String,String,String,String,String,String,String,String,String,String,String,String)"
});
formatter.result({
  "duration": 276979167,
  "status": "passed"
});
});