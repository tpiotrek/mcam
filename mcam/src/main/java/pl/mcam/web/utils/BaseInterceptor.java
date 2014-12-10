package pl.mcam.web.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Tokarz Piotr
 *
 */
public class BaseInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView mav) throws Exception {
		if (mav != null) {
			mav.addObject("baseUrl", getBaseUrl(request));
		}
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {
	}
	
	/**
	 * returns the base url for whole site
	 * @param request the request for which the function checks the base url
	 * @return the base url
	 */
	private String getBaseUrl(HttpServletRequest request) {
		String baseUrl = request.getContextPath();
		if (baseUrl.equals("") || baseUrl.charAt(baseUrl.length()-1) != '/') {
			baseUrl += '/';
		}
		
		return baseUrl;
	}
}
