package com.example.monitorit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FixturesFragment extends Fragment {



    public TextView textViewResult;
    public FixturesFragment() {
        // Required empty public constructor
    }

    private void initViews(View view) {
        textViewResult = view.findViewById(R.id.text_view_result);

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_fixtures);

        //textViewResult = findViewById(R.id.text_view_result);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<ApiResponse> call = jsonPlaceHolderApi.getFixtureResponses();

        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {


                    FixtureResponse[] fixtures = response.body().results;
                    System.out.println("hello");
                    for (FixtureResponse fixture : fixtures) {

                        //String content = fixture.getStrHomeTeam();
                        String content = fixture.getDateEvent() + " : " + fixture.getStrHomeTeam() + " vs " + fixture.getStrAwayTeam() + "\n";
                        content += fixture.getIntHomeScore() + " - " + fixture.getIntAwayScore() + "\n\n";
                        textViewResult.append(content);
                    }
                } else{
                    textViewResult.setText("Error: " + response.code());
                }
            }


            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                textViewResult.setText("Error: " + t.getMessage());
            }

        });
        }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fixtures, container, false);
        initViews(view);
        return view;

    }
}