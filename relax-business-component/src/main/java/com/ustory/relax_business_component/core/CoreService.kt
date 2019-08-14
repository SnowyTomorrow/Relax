package com.ustory.relax_business_component.core

import android.content.Context
import com.ustory.relax_basic_component.config.CoreConfig
import com.ustory.relax_basic_component.core.CoreContext
import com.ustory.relax_business_component.core.dataservice.IDataService
import com.ustory.relax_business_component.core.dataservice.LocalDataService
import com.ustory.relax_business_component.core.dataservice.NetDataService


/**
 * Created by qiyue on 2018/8/19.
 *
 * 核心服务中包含各种公用服务，所以这个放在基础业务层
 */


class CoreService(
    val appContext: Context,
    val config: CoreConfig
) : CoreContext() {

    val netService: IDataService by lazy {
        NetDataService(
            this
        )
    }

    val localService: IDataService by lazy { LocalDataService() }

    val dataService: IDataService = if (config.isOnline) {
        netService
    } else {
        localService
    }

    fun <T : CoreUseCase<*, *>> create(factory: (CoreService) -> T): T = factory(this)


}