package jp.co.sss.book.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * 文字エンコードチェック用フィルタ
 *
 * @author system_shared
 */
@WebFilter(urlPatterns={"/*"})
public class EncodingFilter extends HttpFilter {
    public void doFilter (
        ServletRequest request,ServletResponse response,
        FilterChain chain
    ) throws IOException,ServletException {
        request.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);
    }

}
