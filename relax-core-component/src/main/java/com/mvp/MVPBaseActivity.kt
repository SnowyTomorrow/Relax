package com.mvp

import android.os.Bundle
import com.ustory.relax_basic_component.core.base.BaseAppCompatActivity
import com.mvp.task.SmartTaskManager


/**
 * Created by qiyue on 2016/4/5.
 */
abstract class MVPBaseActivity<P : BasePresenter<*,*>>: BaseAppCompatActivity() {

    abstract var mPresenter: P?
    protected var smartTaskManager: SmartTaskManager? = null;
    abstract var layoutId:Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initView()


    }

    abstract fun initView()


}
