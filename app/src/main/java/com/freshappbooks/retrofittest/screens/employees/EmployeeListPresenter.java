package com.freshappbooks.retrofittest.screens.employees;

import com.freshappbooks.retrofittest.api.ApiFactory;
import com.freshappbooks.retrofittest.api.ApiService;
import com.freshappbooks.retrofittest.pojo.EmployeeResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class EmployeeListPresenter {

    private EmployeeListActivity activity;

    public EmployeeListPresenter(EmployeeListActivity activity) {
        this.activity = activity;
    }

    Disposable disposable;
    public void loadData() {
        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiService apiService = apiFactory.getApiService();
        disposable = apiService.getEmployees().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<EmployeeResponse>() {
                    @Override
                    public void accept(EmployeeResponse employeeResponse) throws Exception {
                        activity.showData(employeeResponse.getResponse());
                    }
                });
    }

    public void disposeDisposable() {
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
