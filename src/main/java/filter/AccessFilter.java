package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(
    filterName = "AccessFilter",
    urlPatterns = {"/clients", "/workers"}
)
public class AccessFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {


  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
    if (!httpServletRequest.getSession().getAttribute("type").equals("Admin") && !httpServletRequest
        .getSession().getAttribute("type").equals("Menadżer")) {
      httpServletResponse.sendRedirect("/main");
    }
    filterChain.doFilter(httpServletRequest, httpServletResponse);
  }

  @Override
  public void destroy() {

  }

}
