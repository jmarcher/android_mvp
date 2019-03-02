package com.nerdscorner.mvplib.events.view

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager

import com.nerdscorner.mvplib.commons.mvp.view.BaseView
import com.nerdscorner.mvplib.events.bus.Bus

import java.lang.ref.WeakReference

abstract class BaseFragmentView : BaseView {

    private var fragmentRef: WeakReference<Fragment>? = null
    var bus: Bus

    val fragmentManager: FragmentManager?
        get() {
            val activity = activity
            return activity?.supportFragmentManager
        }

    val context: Context?
        get() = activity

    val fragment: Fragment?
        get() = fragmentRef?.get()

    constructor(fragment: Fragment) {
        fragmentRef = WeakReference(fragment)
        bus = Bus.defaultEventBus
    }

    constructor(fragment: Fragment, bus: Bus) {
        fragmentRef = WeakReference(fragment)
        this.bus = bus
    }

    override fun getActivity(): FragmentActivity? {
        return fragmentRef?.get()?.activity
    }
}