package com.example.quizapp2020ds.ui.main;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.quizapp2020ds.R;
import com.example.quizapp2020ds.databinding.MainFragmentBinding;
import com.example.quizapp2020ds.ui.quiz.QuizActivity;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
public class MainFragment extends Fragment {



private MainViewModel viewModel;


    private static final String ANY_DIFFICULTY = "ANY DIFFICULTY";
    private static final String ANY_CATEGORY = "ANY CATEGORY";
    private static final String EASY = "EASY";
    private static final String MEDIUM = "MEDIUM";
    private static final String HARD = "HARD";


   private MainFragmentBinding binding;


public static MainFragment newInstance() {
        return new MainFragment();
    }







    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        binding= DataBindingUtil.inflate(inflater,R.layout.main_fragment,container,false);

        seekbar();
        initDifficultSpinner();
initCategorySpinner();
        return binding.getRoot();
    }




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        viewModel.mResult.observe(Objects.requireNonNull(getActivity()), new Observer<Integer>() {
            @Override
            public void onChanged(Integer i) {
               binding.id.setText(String.valueOf(i));
            }
        });





       /* viewModel.test();

        viewModel.mResult.observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
            }
        });*/


        Log.d("fragment name ", "Main Fragment");
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);









        binding.minusB.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               viewModel.minus();
           }
       });
       binding.plusB.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               viewModel.plus();
           }
       });









        binding.Bstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int categoryId = 0;
                if (binding.spinnerCategory.getSelectedIndex() != 0) {
                    categoryId = binding.spinnerCategory.getSelectedIndex() + 8;
                }


                QuizActivity.start(getContext(),
                        binding.seekBar.getProgress(),
                        categoryId
                        , binding.spinnerDifficulty.getSelectedItem().toString());

            }


        });






}

    private void seekbar() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            binding.seekBar.setMin(5);
        }



        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int positionChange, boolean b) {




                    binding.changetextValue.setText(String.valueOf(Integer.valueOf(positionChange)));




                }





            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }


    private void initDifficultSpinner() {
        List<String> difficulty = new LinkedList<>(Arrays.asList(ANY_DIFFICULTY));
        difficulty.add(EASY);
        difficulty.add(MEDIUM);
        difficulty.add(HARD);
        binding.spinnerDifficulty.attachDataSource(difficulty);


        seekbar();
    }

    private void initCategorySpinner() {


    List<String> category = new LinkedList<>(Collections.singletonList(ANY_CATEGORY));

    category.add("GENERAL KNOWLEDGE");
        category.add("ENTERTAINMENT: BOOKS");
        category.add("ENTERTAINMENT: FILM");
        category.add("ENTERTAINMENT: MUSIC");
        category.add("ENTERTAINMENT: MUSICALS & THEATRES");
        category.add("ENTERTAINMENT: TELEVISION");
        category.add("ENTERTAINMENT: VIDEO GAMES");
        category.add("ENTERTAINMENT: BOARD GAMES");
        category.add("SCIENCE & NATURE");
        category.add("SCIENCE: COMPUTERS");
        category.add("SCIENCE: MATHEMATICS");
        category.add("MYTHOLOGY");
        category.add("SPORTS");
        category.add("GEOGRAPHY");
        category.add("HISTORY");
        category.add("POLITICS");
        category.add("ART");
        category.add("CELEBRITIES");
        category.add("ANIMALS");
        category.add("VEHICLES");
        category.add("ENTERTAINMENT: COMICS");
        category.add("SCIENCE: GADGETS");
        category.add("ENTERTAINMENT: JAPANESE ANIME & MANGA");
        category.add("ENTERTAINMENT: CARTOON & ANIMATIONS");

        binding.spinnerCategory.attachDataSource(category);



}



}