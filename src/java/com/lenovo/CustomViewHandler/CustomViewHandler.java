/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lenovo.CustomViewHandler;

import java.io.IOException;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

/**
 *
 * @author UCHE
 */
public class CustomViewHandler extends ViewHandler{

    
    private final ViewHandler parent;

    public CustomViewHandler(ViewHandler parent) {
    //System.out.println("CustomViewHandler.CustomViewHandler():Parent View Handler:"+parent.getClass());
    this.parent = parent;
    }
    
    @Override
    public Locale calculateLocale(FacesContext context) {
        return parent.calculateLocale(context);
    }

    @Override
    public String calculateRenderKitId(FacesContext context) {
        String renderKitId = parent.calculateRenderKitId(context);
        //System.out.println("CustomViewHandler.calculateRenderKitId():RenderKitId: "+renderKitId);
        return renderKitId;
    }

    @Override
    public UIViewRoot createView(FacesContext context, String viewId) {
        return parent.createView(context, viewId);
    }

    @Override
    public String getActionURL(FacesContext context, String viewId) {
        return parent.getActionURL(context, viewId);
    }

    @Override
    public String getResourceURL(FacesContext context, String path) {
        return parent.getResourceURL(context, path);
    }

    @Override
    public void renderView(FacesContext context, UIViewRoot viewToRender) throws IOException, FacesException {
        parent.renderView(context, viewToRender);
    }
    
    @Override
    public UIViewRoot restoreView(FacesContext context, String viewId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        /**
	 * {@link javax.faces.application.ViewExpiredException}. This happens only  when we try to logout from timed out pages.
	 */
	UIViewRoot root =null; 
	root = parent.restoreView(context, viewId);
	if(root == null) {			
            root = createView(context, viewId);
	}
	return root;
    }

    @Override
    public void writeState(FacesContext context) throws IOException {
        parent.writeState(context);
    }
    
    public ViewHandler getParent() {
        return parent;
    }
    
}
