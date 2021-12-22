package com.patel.helpifymp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.patel.helpifymp.Adapters.HelpAdapter;
import com.patel.helpifymp.Models.MentalHealthProblem;
import com.patel.helpifymp.Models.ProfessionalHelp;
import com.patel.helpifymp.databinding.ActivityProfessionalHelpBinding;

import java.util.ArrayList;

public class ProfessionalHelpActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HelpAdapter helpAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professional_help);

        recyclerView = findViewById(R.id.rvPH);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        helpAdapter = new HelpAdapter(this, getPH());
        recyclerView.setAdapter(helpAdapter);

    }

    public ArrayList<ProfessionalHelp> getPH() {
        ArrayList<ProfessionalHelp> list2 = new ArrayList<>();

        ProfessionalHelp n = new ProfessionalHelp();
        n.setDName("Mrunmayee Pathare");
        n.setDSpecilize("Specialized in :Individual and Couple's therapy related to issues like Pregnancy, Infertility, Postpartum Depression, Grief and loss, Parenting, Anxiety and Depression");
        n.setDExperience("Experience : 1 year");
        n.setDMobile("+919854124547");
        list2.add(n);

        n = new ProfessionalHelp();
        n.setDName("Dr. Manjiri Datar ");
        n.setDSpecilize("Specialized in :Psychiatry and Psychotherapy practice for Individuals, Couple and Family related to issues like Anxiety, Depression, Stress across all age groups, Relationship issues, Grief support and Reproductive mental health");
        n.setDExperience("Experience : 15 years");
        n.setDMobile("+918457451232");
        list2.add(n);

        n = new ProfessionalHelp();
        n.setDName("Utkarsha Jagga ");
        n.setDSpecilize("Specialized in :Individual and Couple's therapy related to issues like Anxiety, Complex trauma, Gender, Sexuality, Abuse");
        n.setDExperience("Experience : 2 years");
        n.setDMobile("+919654732514");
        list2.add(n);

        n = new ProfessionalHelp();
        n.setDName("Srishti Asthana");
        n.setDSpecilize("Specialized in : Individual, Couple and Family therapy related to Adjustment Issues, Interpersonal Challenges, Life Changes and Family Issues");
        n.setDExperience("Experience : 3 years");
        n.setDMobile("+918112542584");
        list2.add(n);

        n = new ProfessionalHelp();
        n.setDName("Mrunali Kataria");
        n.setDSpecilize("Specialized in :Individual and Couple's therapy related to issues like Self Image, Relationship Issues, Parenting issues, Career, Work-life issues, Work-performance, Burnout management and Interpersonal relationships with colleagues");
        n.setDExperience("Experience : 2 years");
        n.setDMobile("+917845152214");
        list2.add(n);

        n = new ProfessionalHelp();
        n.setDName("Sharmeen Kaur Khurana");
        n.setDSpecilize("Specialized in :Individual therapy related to Stress management, Anxiety, Career, Life transitions, Grief and loss, Self worth, Identity, Trauma and Abuse");
        n.setDExperience("Experience : 2 years");
        n.setDMobile("+919582165478");
        list2.add(n);

        n = new ProfessionalHelp();
        n.setDName("Dr. Syeda Ruksheda ");
        n.setDSpecilize("Specialized in :Psychiatric practice related to Anxiety, Depression, Women, Families, Teenagers, Young adults, etc.");
        n.setDExperience("Experience : 21 years");
        n.setDMobile("+919717454444");
        list2.add(n);

        n = new ProfessionalHelp();
        n.setDName("Shubhangi More");
        n.setDSpecilize("Specialized in :Individual, Couple and Family therapy related to Depression, Grief, Anxiety, Relationships, Trauma and Personal growth");
        n.setDExperience("Experience : 1 year");
        n.setDMobile("+919874525146");
        list2.add(n);

        n = new ProfessionalHelp();
        n.setDName("Harleen Aneja");
        n.setDSpecilize("Specialized in : Individual therapy related to issues like Workplace Concerns, Stress Management, Parenting issues and Women's Mental Health");
        n.setDExperience("Experience : 3 years");
        n.setDMobile("+918374562525");
        list2.add(n);

        n = new ProfessionalHelp();
        n.setDName("Prachi Naik");
        n.setDSpecilize("Specialized in :Individual Therapy related to Depression, Anxiety, Trauma, LGBTQIA+ and relationship issues");
        n.setDExperience("Experience : 5 years");
        n.setDMobile("+917745214548");
        list2.add(n);

        n = new ProfessionalHelp();
        n.setDName("Siddhika Vlpathi");
        n.setDSpecilize("Specialized in :Individual Therapy related to Anxiety, Depression, Trauma, PTSD, Grief or loss, Body image issues, Relationship, LGBTQIA+, Abuse, Anger and Significant Life Changes");
        n.setDExperience("Experience : 5 years");
        n.setDMobile("+919810258659");
        list2.add(n);

        n = new ProfessionalHelp();
        n.setDName("Saumya Singh");
        n.setDSpecilize("Specialized in :Anxiety, depression, exam stress, adjustment issues, issues that adolescents are facing, marital counselling, individuals in abusive relationships, individuals going through break-ups, parent-child relationship issues, career counselling, etc.");
        n.setDExperience("Experience : 3 years");
        n.setDMobile("+919658472135");
        list2.add(n);

        n = new ProfessionalHelp();
        n.setDName("Aayushi Gumber");
        n.setDSpecilize("Specialized in :Cognitive Behavioural Therapy, Acceptance and Commitment Therapy (ACT), Dialectical Behavioural Therapy (DBT), Interpersonal Therapy (IPT), Family therapy and couple therapy. ");
        n.setDExperience("Experience : 3 years");
        n.setDMobile("+917451248698");
        list2.add(n);

        n = new ProfessionalHelp();
        n.setDName("Ishita Datta");
        n.setDSpecilize("Specialized in :Behavioral Counselling + LGBTQ ");
        n.setDExperience("Experience : 26 years");
        n.setDMobile("+919564215464");
        list2.add(n);

        n = new ProfessionalHelp();
        n.setDName("Srikanth Majjiga");
        n.setDSpecilize("Specialized in :Cognitive Behavioral Therapy, Obsessive-Compulsive Disorder (OCD) , Therapy for Mood Disorders, Therapy for Personality issues, Attention Deficit Hyperactivity Disorder (ADHD), Autism Spectrum Disorder (ASD)");
        n.setDExperience("Experience : 5 years");
        n.setDMobile("+918456214637");
        list2.add(n);

        n = new ProfessionalHelp();
        n.setDName("Hijab Bilgrami");
        n.setDSpecilize("Specialized in :Adolescents and adults with mood disturbances (anxiety, depression, anger, stress), behavioural problems, learning difficulties, ADHD, Study Skills and Relationship Counselling. Cognitive Behaviour Therapy (CBT), Mindfulness-Based Therapy, Problem Focused Therapy, Interpersonal Therapy and Relationship Counselling.");
        n.setDExperience("Experience : 2 years");
        n.setDMobile("+919846521345");
        list2.add(n);

        n = new ProfessionalHelp();
        n.setDName("Shruti Chandran");
        n.setDSpecilize("Specialized in :Emotional/ social/ psychological problems, gender/sexual identity issues, relationship issues, victims of bullying, adolescents having parental discord at home, issues of inferiority complex, self-worth and more.");
        n.setDExperience("Experience : 2 years");
        n.setDMobile("+917845123698");
        list2.add(n);

        n = new ProfessionalHelp();
        n.setDName("Dr Satish Kumar CR");
        n.setDSpecilize("Specialized in :Relationship issues, marital discord, depression, anxiety, insomnia, and mental health care in chronic diseases like cardiovascular disorders, chronic pain disorders, and hypertension.");
        n.setDExperience("Experience : 7 years");
        n.setDMobile("+918526931472");
        list2.add(n);

        n = new ProfessionalHelp();
        n.setDName("Sandeepa Kaur");
        n.setDSpecilize("Specialized in :Cognitive behaviour therapy, dialectical behaviour therapy, mindfulness-based therapy, interpersonal therapy, family and couple therapy, parent management");
        n.setDExperience("Experience : 7 years");
        n.setDMobile("+918456971230");
        list2.add(n);

        n = new ProfessionalHelp();
        n.setDName("Sumbul Alladin");
        n.setDSpecilize("Specialized in :Individual and family counselling, addressing emotional, behavioural, social, educational, career, and developmental issues");
        n.setDExperience("Experience : 12 years");
        n.setDMobile("+919102546398");
        list2.add(n);


        return list2;

    }
}