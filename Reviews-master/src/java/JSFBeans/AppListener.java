/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
//@ApplicationScoped
//@Named
public class AppListener implements PhaseListener {
    //@Inject FacesContext fext;
    //@Inject private ExternalContext ext;

    @Override
    public void afterPhase(PhaseEvent event) {
        //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

//        System.out.println("In phase listener");
//        //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        FacesContext fc = event.getFacesContext();
//        ExternalContext ext = event.getFacesContext().getCurrentInstance().getExternalContext();
//        boolean loginPage = fc.getViewRoot().getViewId().lastIndexOf("Login") > -1 ? true : false;
//        boolean registrationPage = fc.getViewRoot().getViewId().lastIndexOf("registration") > -1 ? true : false;
//        HttpServletRequest request = (HttpServletRequest) ext.getRequest();
//        HttpServletResponse response = (HttpServletResponse) ext.getResponse();
//
//        if (request.getSession().getAttribute("role") == null || request.getSession().getAttribute("role").equals("")) {
//            if (!loginPage) {
//                if (!registrationPage) {
//                    NavigationHandler nh = fc.getApplication().getNavigationHandler();
//                    nh.handleNavigation(fc, null, "gotologin");
//                } else {
//                    System.out.println("Registration");
//                }
//            }
//        } else if (request.getSession().getAttribute("role") == "Admin") {
//            System.out.println("In Admin phase");
//            if (loginPage) {
//                NavigationHandler nh = fc.getApplication().getNavigationHandler();
//                nh.handleNavigation(fc, null, "gotoadmin");
//            }
////            NavigationHandler nh = fc.getApplication().getNavigationHandler();
////            nh.handleNavigation(fc, null, "gotoadmin");
//        } else if (request.getSession().getAttribute("role") == "User") {
//            System.out.println("In User phase");
//            if (loginPage) {
//                NavigationHandler nh = fc.getApplication().getNavigationHandler();
//                nh.handleNavigation(fc, null, "gotouser");
//            }
////            NavigationHandler nh = fc.getApplication().getNavigationHandler();
////            nh.handleNavigation(fc, null, "gotouser");
//        } else {
//            try {
////                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "You are Not Authorised to view this Page . Go Back To Login");
//                NavigationHandler nh = fc.getApplication().getNavigationHandler();
//                nh.handleNavigation(fc, null, "gotologin");
//            } catch (Exception ex) {
//                System.out.println("error" + ex.getMessage());
//            } 
//        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("In First Phase Listener");
//        FacesContext fc = event.getFacesContext();
//        ExternalContext ext = event.getFacesContext().getCurrentInstance().getExternalContext();
//        try {
//            if (event.getPhaseId().equals(PhaseId.RESTORE_VIEW)) {
//                System.out.println("In Phase Listener");
//            }
//            {
//                HttpServletRequest request = (HttpServletRequest) ext.getRequest();
//                HttpServletResponse response = (HttpServletResponse) ext.getResponse();
//                if (request.getSession().getAttribute("role") == null || request.getSession().getAttribute("role").equals("")) {
//                    System.out.println("In Phase Listener - blank group");
//                    request.getServletContext().getRequestDispatcher("/Login.xhtml").forward(request, response);
//                    NavigationHandler nh = fc.getApplication().getNavigationHandler();
//                    nh.handleNavigation(fc, null, "gotologin");
//                    //ext.redirect("/EnterpriseSecureJSF-war/Login.jsf");
//                } else {
//                    if ((request.getRequestURI().contains("/Admin/") && !request.getSession().getAttribute("role").equals("Admin"))) {
//                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "You are Not Authorised to view this Page . Go Back To Login");
//                        NavigationHandler nh = fc.getApplication().getNavigationHandler();
//                        nh.handleNavigation(fc, null, "gotologin");
//                    } else if ((request.getRequestURI().contains("/User/") && !request.getSession().getAttribute("role").equals("User"))) {
//                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "You are Not Authorised to view this Page . Go Back To Login");
//                        NavigationHandler nh = fc.getApplication().getNavigationHandler();
//                        nh.handleNavigation(fc, null, "gotologin");
//                    }
//                }
//            }
//        } catch (Exception e) {
//
//        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
