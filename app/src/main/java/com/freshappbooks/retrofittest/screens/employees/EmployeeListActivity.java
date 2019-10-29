package com.freshappbooks.retrofittest.screens.employees;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.freshappbooks.retrofittest.R;
import com.freshappbooks.retrofittest.adapters.EmployeeAdapter;
import com.freshappbooks.retrofittest.api.ApiFactory;
import com.freshappbooks.retrofittest.api.ApiService;
import com.freshappbooks.retrofittest.pojo.Employee;
import com.freshappbooks.retrofittest.pojo.EmployeeResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class EmployeeListActivity extends AppCompatActivity implements EmployeesListView{

    private RecyclerView recyclerView;
    private EmployeeAdapter adapter;
    Disposable disposable;
    private EmployeeListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        presenter = new EmployeeListPresenter(this);
        recyclerView = findViewById(R.id.recycler_view_employees);
        adapter = new EmployeeAdapter();
        adapter.setEmployees(new ArrayList<Employee>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        presenter.loadData();
    }



    @Override
    protected void onDestroy() {
        presenter.disposeDisposable();
        super.onDestroy();

    }

    @Override
    public void showData(List<Employee> employees) {
        adapter.setEmployees(employees);
    }
}
