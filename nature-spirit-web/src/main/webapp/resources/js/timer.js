function countDown(secs, elem) {
      var element = document.getElementById(elem);
      element.innerHTML = "You have " + secs + " seconds left !";
      if (secs < 1) {
          clearTimeout(timer);
          secs = 1;
          getResult();
      }
      secs--;
      ﻿
              var timer = setTimeout('countDown(' + secs + ',"' + elem + '")', 1000);
  }