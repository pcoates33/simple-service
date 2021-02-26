package pcoates33.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pcoates33.config.TestRefresh;

@RestController
public class VarController {

  private TestRefresh testRefresh;

  @Autowired
  public VarController(TestRefresh testRefresh) {
    this.testRefresh = testRefresh;
  }

  @GetMapping(
      value = "/"
  )
  @ResponseBody
  public String getConfig() {

    StringBuilder html = new StringBuilder();
    html.append("<html><head>\n")
        .append("<script>function postRefresh() {\n")
        .append("const XHR = new XMLHttpRequest();\n")
        .append("XHR.open( 'POST', '/actuator/refresh' );\n")
        .append("XHR.send( );\n")
        .append("}</script>\n")
        .append("</head><body>\n")
        .append("<div><br><br>value1 = ")
        .append(testRefresh.getValue1())
        .append("</div>")
        .append("<div>value2 = ")
        .append(testRefresh.getValue2())
        .append("</div>")
        .append("<div><br><br><button type=\"button\" onclick=\"postRefresh()\">POST:/actuator/refresh</button>")
        .append(" : you need to refresh browser page after doing the POST to actuator/refresh to see changes to config variables</div>")
        .append("</body></body>");

    return html.toString();
  }

}
