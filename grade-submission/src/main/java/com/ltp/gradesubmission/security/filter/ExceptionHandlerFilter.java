package com.ltp.gradesubmission.security.filter;

import com.ltp.gradesubmission.exceptions.EntityNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExceptionHandlerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            try {
                    filterChain.doFilter(request, response);
            }catch (EntityNotFoundException e){
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("Username does not exist!");
                response.getWriter().flush();
            }
            catch (RuntimeException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("BAD REQUEST!");
                response.getWriter().flush();
            }

    }

}
