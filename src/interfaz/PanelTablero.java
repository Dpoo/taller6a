package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class PanelTablero extends JPanel implements ActionListener {
    private int largo;
    private ArrayList<ArrayList< JButton>> botones;
    public PanelTablero(int largo){
        this.largo = largo;
        this.botones =  new ArrayList<>();
        GridLayout gl = new GridLayout(largo,largo);
        setLayout(gl);

        for (int i = 0; i < this.largo; i++) {
            ArrayList<JButton> acF = new ArrayList<>();
            botones.add(acF);
            for (int j = 0; j < this.largo; j++) {
                JButton btn = new JButton("Apagado");
                btn.addActionListener(this);
                btn.setActionCommand(i +","+ j);
                add(btn);
                acF.add(btn);
            }
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] grito = e.getActionCommand().split(",");
        int i = Integer.parseInt(grito[0]);
        int j = Integer.parseInt(grito[1]);
        System.out.println(i+","+j);
        for (int dx = -1; dx < 2; dx++) {
            if(dx + i >= 0 &  dx + i < largo){
                for (int dy = -1; dy < 2; dy++) {
                    if(dy + j >= 0 &  dy + j < largo & dy*dy +dx*dx <=1){
                        JButton acb = botones.get(i+dx).get(j+dy);
                        if(acb.getText().equals("Apagado")){
                            acb.setText("Encendido");
                        }else{
                            acb.setText("Apagado");
                        }

                    }
                }
            }
        }
    }
}
