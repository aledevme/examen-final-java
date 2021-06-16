package com.company;

import com.company.models.Alumno;
import com.company.models.Asignatura;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App extends Frame {

    private TextField nombre, primerApellido, segundoApellido, Dni;
    private TextField nombreAsignatura, grado;

    private Button btnCreateTopic, btnCreateStudent, btnShowInfo;
    private Button btnCreateAsignatura;
    private CardLayout mainApp;
    private Panel cardPanel;

    private List<Map<String, Alumno>> alumnos = new ArrayList<>();
    Map<String , Alumno> hashMapStudent = new HashMap();

    private List<Map<String, Asignatura>> asignaturas = new ArrayList<>();
    Map<String , Alumno> hashMapAsignatura = new HashMap();

    public App(){
        super("Ejemplo de ventana - App Examen final");
        //Eventos

        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

        //Diseño
        cardPanel = new Panel();
        mainApp = new CardLayout();
        cardPanel.setLayout(mainApp);

        //panel de inicio
        Panel inicio = new Panel();
        inicio.add(new Label("Bienvenido al examen final de programación" ));

        //panel crear asignatura
        Panel panelNombreAsignatura = new Panel();
        Panel panelGrado = new Panel();
        Panel numeroAlumnos = new Panel();

        nombreAsignatura = new TextField(50);
        grado = new TextField(50);


        panelNombreAsignatura.setLayout(new FlowLayout());
        panelNombreAsignatura.add(new Label("Nombre"));
        panelNombreAsignatura.add(nombreAsignatura);

        panelGrado.setLayout(new FlowLayout());
        panelGrado.add(new Label("Grado"));
        panelGrado.add(grado);

        numeroAlumnos.setLayout(new FlowLayout());
        numeroAlumnos.add(new Label("Grado"));
        numeroAlumnos.add(new TextField(10));
        numeroAlumnos.add(grado);

        btnCreateAsignatura = new Button();
        numeroAlumnos.add(btnCreateAsignatura);
        btnCreateAsignatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nombreAsignatura.getText().equals("") || grado.getText().equals("") ){
                    System.out.println("Vacio");
                }else{
                    Asignatura asignatura = new Asignatura();
                    asignatura.setNombreAsignatura(nombreAsignatura.getText());
                    asignatura.setGradoAsignatura(grado.getText());

                    //asignaturas.add(grado.getText(), asignatura);
                }
            }
        });



        Panel panelAsignatura = new Panel();
        panelAsignatura.add(new Label("Formulario asignatura"));

        //panel crear alumno
        Panel panelNombre = new Panel();
        Panel panelprimerApellido = new Panel();
        Panel panelsegundoApellido = new Panel();
        Panel panelDni = new Panel();
        Panel panelBoton = new Panel();
        Button addStudent = new Button();

        panelBoton.setLayout(new FlowLayout());
        panelBoton.add(addStudent);
        panelBoton.setSize(100,100);

        addStudent.setPreferredSize(new Dimension(50,20));

        nombre = new TextField(50);
        primerApellido = new TextField(50);
        segundoApellido = new TextField(50);
        Dni = new TextField(30);

        panelNombre.setLayout(new FlowLayout());
        panelNombre.add(new Label("Nombre"));
        panelNombre.add(nombre);

        panelprimerApellido.setLayout(new FlowLayout());
        panelprimerApellido.add(new Label("Primer Apellido"));
        panelprimerApellido.add(primerApellido);

        panelsegundoApellido.setLayout(new FlowLayout());
        panelsegundoApellido.add(new Label("Segundo Apellido"));
        panelsegundoApellido.add(segundoApellido);

        panelDni.setLayout(new FlowLayout());
        panelDni.add(new Label("Dni"));
        panelDni.add(Dni);

        Panel panelAlumno = new Panel();
        panelAlumno.add(new Label("Formulario alumno"));
        panelAlumno.setLayout(new GridLayout(7,1));
        panelAlumno.add(panelNombre);
        panelAlumno.add(panelprimerApellido);
        panelAlumno.add(panelsegundoApellido);
        panelAlumno.add(panelDni);
        panelAlumno.add(addStudent);

        addStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nombre.getText().equals("") || primerApellido.getText().equals("") || segundoApellido.getText().equals("") || Dni.getText().equals("") ){
                    System.out.println("Vacio");
                }else{
                    Alumno student = new Alumno();
                    student.setNombre(nombre.getText());
                    student.setPrimerApellido(primerApellido.getText());
                    student.setSegundoApellido(segundoApellido.getText());
                    student.setDni(Dni.getText());
                    hashMapStudent.put(Dni.getText(), student);
                    alumnos.add(hashMapStudent);
                }
            }
        });

        //panel mostrar información
        Panel panelInformacion = new Panel();
        panelInformacion.add(new Label("informacion"));

        //pantallas
        cardPanel.add(inicio, "inicial");
        cardPanel.add(panelAsignatura, "asignatura");
        cardPanel.add(panelAlumno, "alumno");
        cardPanel.add(panelInformacion, "informacion");

        //controlador de las vistas
        Panel controlPanel = new Panel();
        btnCreateTopic = new Button();
        btnCreateStudent = new Button();
        btnShowInfo = new Button();

        btnCreateTopic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.show(cardPanel, "asignatura");
            }
        });

        btnCreateStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.show(cardPanel, "alumno");
            }
        });

        btnShowInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.show(cardPanel, "informacion");
            }
        });

        controlPanel.add(btnCreateTopic);
        controlPanel.add(btnCreateStudent);
        controlPanel.add(btnShowInfo);

        this.setLayout(new BorderLayout());

        this.add(controlPanel,BorderLayout.SOUTH);
        this.add(cardPanel,BorderLayout.CENTER);

        this.setSize(800,500);
        this.setVisible(true);




    }

}
