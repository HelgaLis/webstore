package webstore.interceptor;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class RequestTimeLogInterceptor implements HandlerInterceptor {
	private static final Logger LOGGER = Logger.getLogger(RequestTimeLogInterceptor.class); 
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,Object handler, ModelAndView modelAndView) throws Exception {
		String queryStr = request.getQueryString()==null?"":"?"+request.getQueryString();
		String path = request.getRequestURL()+queryStr;
		long startTime=(Long)request.getAttribute("startTime");
		long endTime =System.currentTimeMillis();
		LOGGER.info(String.format("%s ms processed request %s", (endTime - startTime),path));

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception {
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return true;
	}

}
