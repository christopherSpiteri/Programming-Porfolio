/*
Tried to do the update but when implemented the numberOfQuestion was not incrementing when a new quiz was created 
but the update was working when the doing to open Quiz operation.
*/

import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class Quizmaker extends javax.swing.JFrame 
{

    int numberOfQuestion = 1;
    //arrays to be used to save the questions and answers 
    ArrayList<String> questionList = new ArrayList();
    ArrayList<String> answerList = new ArrayList();
    ArrayList<Boolean> correctAnswers = new ArrayList();
    
    String filePath = "";
    String toWrite = "";
    
    public Quizmaker() {
        initComponents();
        NewQuiz.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NewQuiz = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        answer2 = new javax.swing.JTextField();
        answer4 = new javax.swing.JTextField();
        answer3 = new javax.swing.JTextField();
        answer1 = new javax.swing.JTextField();
        CheckBox1 = new javax.swing.JCheckBox();
        CheckBox2 = new javax.swing.JCheckBox();
        CheckBox3 = new javax.swing.JCheckBox();
        CheckBox4 = new javax.swing.JCheckBox();
        saveBtn = new javax.swing.JButton();
        Clearbtn = new javax.swing.JButton();
        fileCommit = new javax.swing.JButton();
        counterLbl = new javax.swing.JLabel();
        titleLbl = new javax.swing.JLabel();
        frame = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newQuiz = new javax.swing.JMenuItem();
        openQuiz = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        Quit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        About = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quiz Maker");
        setResizable(false);

        jLabel1.setText("Quiz Title:");

        jLabel2.setText("Question no:");

        jLabel3.setText("Question:");

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        jLabel4.setText("Answers:");

        CheckBox1.setText("Correct");

        CheckBox2.setText("Correct");

        CheckBox3.setText("Correct");

        CheckBox4.setText("Correct");

        saveBtn.setText("Save Question");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        Clearbtn.setText("Clear Question");
        Clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearbtnActionPerformed(evt);
            }
        });

        fileCommit.setText("Commit To File");
        fileCommit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileCommitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NewQuizLayout = new javax.swing.GroupLayout(NewQuiz);
        NewQuiz.setLayout(NewQuizLayout);
        NewQuizLayout.setHorizontalGroup(
            NewQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewQuizLayout.createSequentialGroup()
                .addGroup(NewQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NewQuizLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(titleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(NewQuizLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(NewQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(NewQuizLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(NewQuizLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(counterLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(NewQuizLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addGroup(NewQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(NewQuizLayout.createSequentialGroup()
                                        .addComponent(answer4, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(CheckBox4))
                                    .addGroup(NewQuizLayout.createSequentialGroup()
                                        .addComponent(answer3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(CheckBox3))
                                    .addGroup(NewQuizLayout.createSequentialGroup()
                                        .addComponent(answer2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(CheckBox2))
                                    .addGroup(NewQuizLayout.createSequentialGroup()
                                        .addComponent(answer1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(CheckBox1))
                                    .addGroup(NewQuizLayout.createSequentialGroup()
                                        .addComponent(saveBtn)
                                        .addGap(29, 29, 29)
                                        .addComponent(Clearbtn)))))))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NewQuizLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(fileCommit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        NewQuizLayout.setVerticalGroup(
            NewQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewQuizLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NewQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(titleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(NewQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(counterLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(NewQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(NewQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(answer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(NewQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CheckBox2))
                .addGap(10, 10, 10)
                .addGroup(NewQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answer3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CheckBox3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(NewQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answer4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CheckBox4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NewQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(Clearbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fileCommit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        newQuiz.setText("New Quiz");
        newQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newQuizActionPerformed(evt);
            }
        });
        jMenu1.add(newQuiz);

        openQuiz.setText("Open Quiz");
        openQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openQuizActionPerformed(evt);
            }
        });
        jMenu1.add(openQuiz);
        jMenu1.add(jSeparator1);

        Quit.setText("Quit");
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });
        jMenu1.add(Quit);

        frame.add(jMenu1);

        jMenu2.setText("Help");

        About.setText("About");
        About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutActionPerformed(evt);
            }
        });
        jMenu2.add(About);

        frame.add(jMenu2);

        setJMenuBar(frame);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NewQuiz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NewQuiz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_QuitActionPerformed

    private void AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutActionPerformed
        
        AboutFrame s = new AboutFrame();
        s.setVisible(true);
        
    }//GEN-LAST:event_AboutActionPerformed
    
    /*
      The new quiz menu displays the newQuiz JForm clears the toWrite string to add new Quiz with 3 new filled arrays
      - Clears the arrays
      - Opens the save dialog to save the quiz
      - get title from quiz name
    */
    private void newQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newQuizActionPerformed
        NewQuiz.setVisible(true);
        
        toWrite = "";
        
        questionList.clear();
        answerList.clear();
        correctAnswers.clear();
        
        numberOfQuestion = 1;
        counterLbl.setText(numberOfQuestion + "");
        
        Clearbtn.setText("Clear Question");
        
        filePath = FileIO.showSaveDialog();
        
        
        String pathName = getQuizNameFromPath(filePath); 
        /*this string is storing the name of the files name
        which is taken from the filepath of the text file and removing the .txt to get the title so that it can be used 
        as a title for the quiz
        */
        
        titleLbl.setText(pathName);
        
    }//GEN-LAST:event_newQuizActionPerformed
    
    /*
        this method adds all the arrays in one string with a format
        and writes that string in the text file
    */
    private void fileCommitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileCommitActionPerformed
        
        for(int i = 0; i < questionList.size(); i++)
        {
           toWrite += "$" + questionList.get(i) + ";" + "\r\n"
           + correctAnswers.get(i*4) + "," + answerList.get(i*4) + "." + ";" + "\r\n"
           + correctAnswers.get((i*4)+1) + "," + answerList.get((i*4)+1) + "." + ";" + "\r\n"
           + correctAnswers.get((i*4)+2) + "," + answerList.get((i*4)+2) + "." + ";" + "\r\n"
           + correctAnswers.get((i*4)+3) + "," + answerList.get((i*4)+3) + "." + ";" + "\r\n";
        }
      
        //System.out.println(toWrite);
        
        questionList.clear();
        answerList.clear();
        correctAnswers.clear();
        
        FileIO.writeToTextFile(filePath, toWrite);
        //this method is writing the quiz questions and answers in the textfile
    }//GEN-LAST:event_fileCommitActionPerformed

    //this button clears the text fields and checkboxes of the Gui
    private void ClearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearbtnActionPerformed
    
       clearAll();
        
    }//GEN-LAST:event_ClearbtnActionPerformed

    //this method saved all the questions and clears the text
    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        
        if(txtArea.getText().isEmpty() || answer1.getText().isEmpty() || answer2.getText().isEmpty() ||
                answer3.getText().isEmpty() || answer4.getText().isEmpty() || (!CheckBox1.isSelected() && !CheckBox2.isSelected()
                && !CheckBox3.isSelected() && !CheckBox4.isSelected()))
        {
            JOptionPane.showMessageDialog(this,"Please enter required Values!"); 
        }
        else
        {
            addQuestionToLists();    
            //this method is used to add the current question to the list when the save button is pressed
            clearAll();
           
            numberOfQuestion += 1;
            counterLbl.setText(numberOfQuestion + "");
        }
//        System.out.println(questionList);
//        System.out.println(answerList);
//        System.out.println(correctAnswers);

    }//GEN-LAST:event_saveBtnActionPerformed

    private void openQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openQuizActionPerformed
        
        NewQuiz.setVisible(true);
        numberOfQuestion = 1;
        counterLbl.setText(numberOfQuestion + "");
        
        questionList.clear();
        answerList.clear();
        correctAnswers.clear();
        
        filePath = FileIO.showOpenDialog(); 
        
        String readfile = FileIO.readTextFile(filePath);
        String pathName = getQuizNameFromPath(filePath);
        
        titleLbl.setText(pathName);
       
        Clearbtn.setText("Next Question");
        
        fillUpArrays(readfile);
        showQuestion(numberOfQuestion);
    }//GEN-LAST:event_openQuizActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Quizmaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quizmaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quizmaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quizmaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quizmaker().setVisible(true);
            }
        });
    }
    
    //This method is used to add the questions to the list 
    public void addQuestionToLists()
    {
        questionList.add(txtArea.getText());

        answerList.add(answer1.getText());
        answerList.add(answer2.getText());
        answerList.add(answer3.getText());
        answerList.add(answer4.getText());

        correctAnswers.add(CheckBox1.isSelected());
        correctAnswers.add(CheckBox2.isSelected());
        correctAnswers.add(CheckBox3.isSelected());
        correctAnswers.add(CheckBox4.isSelected());
    }
    
    //Clearing all the text fields and checkboxes Or goes to next Question
    public void clearAll() 
    {
        if(Clearbtn.getText().equals("Clear Question"))
        {
            txtArea.setText("");
            answer1.setText("");
            answer2.setText("");
            answer3.setText("");
            answer4.setText("");

            CheckBox1.setSelected(false);
            CheckBox2.setSelected(false);
            CheckBox3.setSelected(false);
            CheckBox4.setSelected(false);
        }
        else if(Clearbtn.getText().equals("Next Question"))
        {
            for(int i = 0; i <= questionList.size(); i++)
            {
                if(numberOfQuestion == questionList.size())
                {
                    txtArea.setText(questionList.get(0));
                    answer1.setText(answerList.get(0));
                    answer2.setText(answerList.get(1));
                    answer3.setText(answerList.get(2));
                    answer4.setText(answerList.get(3));
                    
                    CheckBox1.setSelected(correctAnswers.get(0));
                    CheckBox2.setSelected(correctAnswers.get(1));
                    CheckBox3.setSelected(correctAnswers.get(2));
                    CheckBox4.setSelected(correctAnswers.get(3));
                    
                    numberOfQuestion = 1;
                    counterLbl.setText(numberOfQuestion + "");
                }
                else
                {
                    txtArea.setText(questionList.get(0 + numberOfQuestion));
                    numberOfQuestion = numberOfQuestion + 1;
                    counterLbl.setText(numberOfQuestion + "");
                    
                    for(int r = 1; r <= questionList.size(); r++)
                    {
                        answer1.setText(answerList.get(r+1));
                        answer2.setText(answerList.get(r+2));
                        answer3.setText(answerList.get(r+3));
                        answer4.setText(answerList.get(r+4));
                        
                        CheckBox1.setSelected(correctAnswers.get(r +1));
                        CheckBox2.setSelected(correctAnswers.get(r + 2));
                        CheckBox3.setSelected(correctAnswers.get(r + 3));
                        CheckBox4.setSelected(correctAnswers.get(r+ 4));
                    }
                }
            }
        }
            
    }
    
    //Getting the name of the quiz from the file path of the txt file
    public static String getQuizNameFromPath(String Path)
    {
        File newFile = new File(Path);
        
        String fileName = newFile.getName();
        String name = fileName.substring(0,fileName.length()-4);
        return name;
    }
    
    //Method used to fill up the arraylist from the string.
    public void fillUpArrays(String readline)
    {
        String[] files = readline.split("\\$|\\;");
        String[] files2 = readline.split("\\?|\\;");
        
        for(int j = 1; j < files.length; j++)
        {
            if(files[j].endsWith("?"))
            {
                questionList.add(files[j]);
            }
        }
        
        for(int a = 1; a < files2.length; a++)
        {
           if(files2[a].endsWith("."))
           {
              answerList.add(files2[a].substring(files2[a].indexOf(",")+1,files2[a].indexOf(".")));
           }
        }
        
        for(int b = 1; b < files.length; b++)
        {   
            if(files[b].contains("true") || files[b].contains("false"))
            {
                boolean trueOrFalse  = Boolean.parseBoolean(files[b].substring(0,files[b].indexOf(",")));
                correctAnswers.add(trueOrFalse);
            }
        }
        
//        System.out.println(questionList);
//        System.out.println(answerList);
//        System.out.println(correctAnswers);
        
        /*for(int i = 1; i < files.length; i++)
        {
            System.out.println(files[i]);
        }*/  
    }
    
    public void showQuestion(int numberOfQuestion)
    {
        
        for(int i = numberOfQuestion; i <= questionList.size(); i++)
        {
            txtArea.setText(questionList.get(0));
        }
        
        for(int y = numberOfQuestion; y <= answerList.size(); y++)
        {
            answer1.setText(answerList.get(0));
            answer2.setText(answerList.get(1));
            answer3.setText(answerList.get(2));
            answer4.setText(answerList.get(3));
            
            CheckBox1.setSelected(correctAnswers.get(0));
            CheckBox2.setSelected(correctAnswers.get(1));
            CheckBox3.setSelected(correctAnswers.get(2));
            CheckBox4.setSelected(correctAnswers.get(3));
        }
    
        
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem About;
    private javax.swing.JCheckBox CheckBox1;
    private javax.swing.JCheckBox CheckBox2;
    private javax.swing.JCheckBox CheckBox3;
    private javax.swing.JCheckBox CheckBox4;
    private javax.swing.JButton Clearbtn;
    private javax.swing.JPanel NewQuiz;
    private javax.swing.JMenuItem Quit;
    private javax.swing.JTextField answer1;
    private javax.swing.JTextField answer2;
    private javax.swing.JTextField answer3;
    private javax.swing.JTextField answer4;
    private javax.swing.JLabel counterLbl;
    private javax.swing.JButton fileCommit;
    private javax.swing.JMenuBar frame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem newQuiz;
    private javax.swing.JMenuItem openQuiz;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}
