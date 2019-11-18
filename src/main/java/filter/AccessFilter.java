package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(
    filterName = "StatusFilter",
    urlPatterns = {"/clients", "/workers"}
)
public class AccessFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
    if (httpServletRequest.getSession().getAttribute("type") != "Admin" || httpServletRequest.getSession().getAttribute("type") != "Menager") {
      httpServletResponse.sendRedirect("/main");
    }

    filterChain.doFilter(httpServletRequest, httpServletResponse);
  }

}