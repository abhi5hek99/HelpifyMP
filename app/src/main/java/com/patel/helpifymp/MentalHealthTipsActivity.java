package com.patel.helpifymp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.patel.helpifymp.Adapters.TipsAdapter;
import com.patel.helpifymp.Models.MentalHealthProblem;

import java.util.ArrayList;

public class MentalHealthTipsActivity extends AppCompatActivity{

    RecyclerView mRecyclerView;
    TipsAdapter tipsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_health_tips);

        mRecyclerView = findViewById(R.id.rvMHT);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        tipsAdapter = new TipsAdapter(this, getMht());
        mRecyclerView.setAdapter(tipsAdapter);
    }


    public ArrayList<MentalHealthProblem> getMht() {

        ArrayList<MentalHealthProblem> list = new ArrayList<>();

        MentalHealthProblem m = new MentalHealthProblem();
        m.setPname("Mood disorders (such as depression or bipolar disorder)");
        m.setPtip("Depression affects how you feel, think and behave, and there are physical symptoms as well. Try talking out with people about how you feel or try getting professional help if nothing works out. Depression can be dealt if you have faith in yourself!!! Bipolar disorder causes extreme mood changes that affect or disrupt daily life. It can be taken care by professional help or you can try the support of a close friend or family member which will help you a lot!!!");
        list.add(m);

        m = new MentalHealthProblem();
        m.setPname("Anxiety disorders");
        m.setPtip("Anxiety is the body’s physical response to a threat or perceived threat. It causes a pounding heart, rapid breathing, butterflies in the stomach and a burst of energy as well as mental responses such as excessive fears, worries or obsessive thinking. You can overcome it by making changes in your lifestyle. You can workout, go out for a run, talk to your friends and family about your feelings and overwhelming emotions. You can overcome it all. ");
        list.add(m);

        m = new MentalHealthProblem();
        m.setPname("Personality disorders");
        m.setPtip("A personality disorder refers to a long-term pattern of thinking, behaviour and emotion that is dysfunctional, extreme and inflexible. It causes distress and makes it difficult to function in everyday life. People with personality disorders find it hard to change their behaviour or adapt to different situations. It can be difficult for someone with a personality disorder to learn to trust a doctor or therapist. However, establishing a positive relationship with a healthcare provider is an important step towards recovery. The treatment may vary, based on the type of personality disorder and any other conditions that might be present.");
        list.add(m);

        m = new MentalHealthProblem();
        m.setPname("Psychotic disorders (such as schizophrenia)");
        m.setPtip("Schizophrenia is a mental illness that causes someone to have an altered experience of reality. It causes psychosis, when people experience delusions and hallucinations. Schizophrenia affects people’s thoughts, perceptions and behaviour and interferes with their ability to function at work, school or relate to other people. Treatment should be under the care of a psychiatrist, but may involve a team of different mental health professionals, including a doctor, mental health nurse, social worker, occupational therapist and clinical psychologist. Treatments are tailored according to the needs of the individual. Research has shown that early treatment can be more effective, before the illness has time to cause damage.");
        list.add(m);

        m = new MentalHealthProblem();
        m.setPname("Eating disorders");
        m.setPtip("An eating disorder is a serious mental health condition that involves an unhealthy relationship with food. Eating disorders can have a significant physical and emotional impact on the person affected, and their family. Starting treatment as early as possible is important because there can be long-term health consequences for people with chronic eating disorders. There is no 'one size fits all' approach to treating eating disorders since everyone is different. Often a team of health professionals is involved in an individual's treatment, including a psychologist, dietitian and doctor. The treatment can also include counselling, nutrition education, family approach, medication or providing care to the person according to the need of the situation.");
        list.add(m);

        m = new MentalHealthProblem();
        m.setPname("Trauma-related disorders (such as post-traumatic stress disorder)");
        m.setPtip("Post-traumatic stress disorder (PTSD) is a treatable anxiety disorder which happens when fear, anxiety and memories of a traumatic event don't go away. The feelings last for a long time and interfere with how people cope with everyday life.Many people have some symptoms of PTSD in the first couple of weeks after a traumatic event, but most recover on their own or with the help of family and friends. For people whose symptoms last longer, PTSD is treated with psychotherapy or sometimes medicine, or both. Everyone's PTSD is different, so if you have PTSD you might need to try a few different types of treatment before you find something that works for you.");
        list.add(m);

        m = new MentalHealthProblem();
        m.setPname("Substance abuse disorders");
        m.setPtip("Using drugs can affect the lives of those caught up in it in ways they might not expect. It can affect health, relationships, jobs and education. Recognising whether you or someone close to you has a problem with drugs is an important first step in seeking help and treatment. If you have a problem, you could try talking to someone such as a family member, teacher or doctor about what to do next. If you’re concerned about someone else, find out how you can help them with their drug problem.");
        list.add(m);

        return list;
    }
}

