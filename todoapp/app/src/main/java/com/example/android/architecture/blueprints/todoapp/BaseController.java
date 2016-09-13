package com.example.android.architecture.blueprints.todoapp;

import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.View;

import com.bluelinelabs.conductor.Controller;

public abstract class BaseController extends Controller {
    private boolean mActive = false;

    protected ActionBar getActionBar() {
        ActionBarProvider actionBarProvider = ((ActionBarProvider)getActivity());
        return actionBarProvider != null ? actionBarProvider.getSupportActionBar() : null;
    }

    protected DrawerLayout getDrawerLayout() {
        DrawerLayoutProvider actionBarProvider = ((DrawerLayoutProvider)getActivity());
        return actionBarProvider != null ? actionBarProvider.getDrawerLayout() : null;
    }

    @Override
    protected void onAttach(@NonNull View view) {
        super.onAttach(view);
        // Default settings to reset Activity UI state to each time a new controller is loaded.
        ActionBar actionBar = getActionBar();
        actionBar.setTitle("");
        actionBar.setDisplayHomeAsUpEnabled(false);

        DrawerLayout drawerLayout = getDrawerLayout();
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    protected void setActive(boolean active) {
        mActive = active;
    }

    public boolean isActive() {
        return mActive;
    }
}