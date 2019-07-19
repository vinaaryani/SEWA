/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sewa;

/**
 *
 * @author Acer
 */

//memanggil library/api yang diperlukan
import Koneksi.koneksidb;
import java.sql.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class formTransaksi extends javax.swing.JFrame {

    //membuat objek    
    private DefaultTableModel model;
    
    //deklarasi variabel
    String id_peminjam, id_petugas, nama_petugas, id_penyewa, nama_penyewa, id_kamera, merk_kamera, tanggal_pinjam, jaminan_pinjam;
    Integer harga_sewa;
    
    /**
     * Creates new form formTransaksi
     */
    public formTransaksi() {
        initComponents();
        
        //membuat obyek
        model = new DefaultTableModel();
        
        //memberi nama header pada tabel
        tabeltransaksi.setModel(model);
        model.addColumn("ID PEMINJAM");
        model.addColumn("ID PETUGAS");
        model.addColumn("ID PENYEWA");
        model.addColumn("ID KAMERA");
        model.addColumn("MERK KAMERA");
        model.addColumn("TANGGAL PINJAM");
        model.addColumn("JAMINAN PINJAM");
        model.addColumn("HARGA SEWA");
        
        combo_idpetugas();
        combo_idpenyewa();
        combo_idkamera();
        getDataPeminjam();
    }
    
        public void getDataPeminjam(){
        //kosongkan tabel
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        //eksekusi koneksi dan kirimkan query ke database
        try{
            //tes koneksi
            Statement stat = (Statement) koneksidb.getKoneksi().createStatement();
            
            //perintah sql untuk membaca data dari tabel kategori        
            String sql = "SELECT * FROM peminjaman";
            ResultSet res = stat.executeQuery(sql);
            
            //baca data
            while(res.next()){
                //membuat obyek berjenis array
                Object[] obj = new Object[8];
                obj[0]=res.getString("id_peminjam");
                obj[1]=res.getString("id_petugas");
                obj[2]=res.getString("id_penyewa");
                obj[3]=res.getString("id_kamera");
                obj[4]=res.getString("merk_kamera");
                obj[5]=res.getString("tanggal_pinjam");
                obj[6]=res.getString("jaminan_pinjam");
                obj[7]=res.getString("harga_sewa");
                model.addRow(obj);
            }
        }catch(SQLException err){
           JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
        
    //membaca data 
    public void loadDataPeminjam(){
        id_peminjam = tidpinjam.getText();
        id_petugas = (String) combo_idpetugas.getSelectedItem();
        id_penyewa = (String) idpenyewa.getSelectedItem();
        id_kamera = (String) idkamera.getSelectedItem();
        merk_kamera = tmerkkamera.getText();
        tanggal_pinjam = ttanggalpinjam.getText();
        jaminan_pinjam = tjaminan.getText();
        harga_sewa = Integer.parseInt(thargasewa.getText());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabeltransaksi = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tidpinjam = new javax.swing.JTextField();
        tmerkkamera = new javax.swing.JTextField();
        thargasewa = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tjaminan = new javax.swing.JTextField();
        combo_idpetugas = new javax.swing.JComboBox<>();
        idpenyewa = new javax.swing.JComboBox<>();
        idkamera = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtnama_petugas = new javax.swing.JTextField();
        txtnama_penyewa = new javax.swing.JTextField();
        ttanggalpinjam = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        bsimpan = new javax.swing.JButton();
        breset = new javax.swing.JButton();
        bubah = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabeltransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabeltransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeltransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabeltransaksi);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel2.setText("ID Peminjam");

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel4.setText("Merk Kamera");

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel5.setText("ID Kamera");

        jLabel10.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel10.setText("ID Petugas");

        jLabel6.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel6.setText("Tanggal Pinjam");

        jLabel11.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel11.setText("ID Penyewa");

        jLabel7.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel7.setText("Harga Sewa / Hari");

        tmerkkamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tmerkkameraActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel12.setText("Jaminan Pinjam");

        combo_idpetugas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Petugas-" }));
        combo_idpetugas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_idpetugasItemStateChanged(evt);
            }
        });
        combo_idpetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_idpetugasActionPerformed(evt);
            }
        });

        idpenyewa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Penyewa-" }));
        idpenyewa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                idpenyewaItemStateChanged(evt);
            }
        });
        idpenyewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idpenyewaActionPerformed(evt);
            }
        });

        idkamera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Produk-" }));
        idkamera.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                idkameraItemStateChanged(evt);
            }
        });
        idkamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idkameraActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel13.setText("Nama Petugas");

        jLabel14.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel14.setText("Nama Penyewa");

        txtnama_petugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnama_petugasActionPerformed(evt);
            }
        });

        txtnama_penyewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnama_penyewaActionPerformed(evt);
            }
        });

        ttanggalpinjam.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/dd"))));
        ttanggalpinjam.setText("bln tg, thnn");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idpenyewa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtnama_petugas)
                    .addComponent(combo_idpetugas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tidpinjam)
                    .addComponent(txtnama_penyewa))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel12))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idkamera, 0, 148, Short.MAX_VALUE)
                    .addComponent(tmerkkamera, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(thargasewa)
                    .addComponent(tjaminan)
                    .addComponent(ttanggalpinjam))
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tidpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idkamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_idpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(tmerkkamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnama_petugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(thargasewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idpenyewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel6)
                    .addComponent(ttanggalpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnama_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(tjaminan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        bsimpan.setBackground(new java.awt.Color(102, 102, 102));
        bsimpan.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        bsimpan.setText("SIMPAN");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        breset.setBackground(new java.awt.Color(102, 102, 102));
        breset.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        breset.setText("RESET");
        breset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bresetActionPerformed(evt);
            }
        });

        bubah.setBackground(new java.awt.Color(102, 102, 102));
        bubah.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        bubah.setText("UBAH");
        bubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubahActionPerformed(evt);
            }
        });

        bhapus.setBackground(new java.awt.Color(102, 102, 102));
        bhapus.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        bhapus.setText("HAPUS");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        bkeluar.setBackground(new java.awt.Color(102, 102, 102));
        bkeluar.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        bkeluar.setText("KELUAR");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(breset, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bubah, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(breset, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bubah, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel1.setText(" PEMINJAMAN KAMERA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    
    //memilih data saat baris pada tabel dipilih dengan mouse
    public void dataSelect(){
        //deklarasi variabel
        int i = tabeltransaksi.getSelectedRow();
        
        //uji adakah data di tabel?
        if(i == -1){
            //tidak ada yang terpilih atau dipilih.
            return;
        }
        tidpinjam.setText(""+model.getValueAt(i,0));
        combo_idpetugas.setSelectedItem(""+model.getValueAt(i,1));
        idpenyewa.setSelectedItem(""+model.getValueAt(i,2));
        idkamera.setSelectedItem(""+model.getValueAt(i,3));
        //tmerkkamera.setText(""+model.getValueAt(i,4));
        //thargasewa.setText(""+model.getValueAt(i,5));
        ttanggalpinjam.setText(""+model.getValueAt(i,5));
        tjaminan.setText(""+model.getValueAt(i,6));
        
        
    }
    
    
    public void combo_idpetugas()
    {
        try {
            Statement stat = (Statement) koneksidb.getKoneksi().createStatement();
            String sql = "SELECT id_petugas FROM petugas order by id_petugas asc";
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                Object[] ob = new Object[3];
                ob[0] = res.getString(1);
            
                combo_idpetugas.addItem((String) ob[0]);
            }
            res.close();
            stat.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    //fungsi untuk menampilkan data petugas pada textbox
    public void dataPetugas(){   
        try{
            //tes koneksi
            Statement stat = (Statement) koneksidb.getKoneksi().createStatement();
           
            //perintah sql untuk membaca data dari tabel produk
            String sql = "SELECT * FROM petugas WHERE id_petugas = '"+ combo_idpetugas.getSelectedItem()+"'";
            ResultSet res = stat.executeQuery(sql);   
            
            while(res.next()){
               txtnama_petugas.setText(res.getString("nama_petugas"));
            }
        }catch(SQLException err){
           JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public void combo_idpenyewa()
    {
        try {
            Statement stat = (Statement) koneksidb.getKoneksi().createStatement();
            String sql = "SELECT id_penyewa FROM penyewa order by id_penyewa asc";
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                Object[] ob = new Object[3];
                ob[0] = res.getString(1);
            
                idpenyewa.addItem((String) ob[0]);
            }
            res.close();
            stat.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    //fungsi untuk menampilkan data petugas pada textbox
    public void dataPenyewa(){   
        try{
            //tes koneksi
            Statement stat = (Statement) koneksidb.getKoneksi().createStatement();
           
            //perintah sql untuk membaca data dari tabel produk
            String sql = "SELECT * FROM penyewa WHERE id_penyewa = '"+ idpenyewa.getSelectedItem() +"'";
            ResultSet res = stat.executeQuery(sql);   
            
            while(res.next()){
               txtnama_penyewa.setText(res.getString("nama_penyewa"));
            }
        }catch(SQLException err){
           JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public void combo_idkamera()
    {
        try {
            Statement stat = (Statement) koneksidb.getKoneksi().createStatement();
            String sql = "SELECT id_kamera FROM produk order by id_kamera asc";
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                Object[] ob = new Object[3];
                ob[0] = res.getString(1);
            
                idkamera.addItem((String) ob[0]);
            }
            //res.close();
            //stat.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    //fungsi untuk menampilkan data pada textbox
    public void dataProduk(){   
        try{
            //tes koneksi
            Statement stat = (Statement) koneksidb.getKoneksi().createStatement();
           
            //perintah sql untuk membaca data dari tabel produk
            String sql = "SELECT * FROM produk WHERE id_kamera = '"+ idkamera.getSelectedItem() +"'";
            ResultSet res = stat.executeQuery(sql);
                        
            //baca data dan tampilkan pada text produk dan harga
            while(res.next()){
                //membuat obyek berjenis array
               tmerkkamera.setText(res.getString("merk_kamera"));
               thargasewa.setText(res.getString("harga_sewa"));
            }
        }catch(SQLException err){
           JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    //mengosongkan form
    public void reset(){
        id_peminjam = "";
        id_petugas = "";
        nama_petugas = "";
        id_penyewa = "";
        nama_penyewa = "";
        id_kamera = "";
        merk_kamera = "";
        tanggal_pinjam = "";
        jaminan_pinjam = "";
        harga_sewa = 0;
               
        tidpinjam.setText(id_petugas);
        combo_idpetugas.setSelectedItem("-Pilih Petugas-");
        txtnama_petugas.setText(nama_petugas);
        idpenyewa.setSelectedItem("-Pilih Penyewa-");
        txtnama_penyewa.setText(nama_penyewa);
        idkamera.setSelectedItem("-Pilih Produk-");
        tmerkkamera.setText(merk_kamera);
        ttanggalpinjam.setText(tanggal_pinjam);
        tjaminan.setText(jaminan_pinjam);
        thargasewa.setText(Integer.toString(harga_sewa));
    }
    
    public void simpanDataPeminjaman(){
        //uji koneksi dan eksekusi perintah
        loadDataPeminjam();
        try{
            //test koneksi
            Statement stat = (Statement) koneksidb.getKoneksi().createStatement();
            
            //perintah sql untuk simpan data
            String  sql =   "INSERT INTO peminjaman(id_peminjam, id_petugas, id_penyewa, id_kamera, merk_kamera, tanggal_pinjam, jaminan_pinjam, harga_sewa)"
                            + "VALUES('"+ id_peminjam +"','"+ id_petugas +"','"+ id_penyewa +"','"+ id_kamera +"','"+merk_kamera+"','"+tanggal_pinjam+"','"+jaminan_pinjam+"','"+harga_sewa+"')";
            PreparedStatement p = (PreparedStatement) koneksidb.getKoneksi().prepareStatement(sql);
            p.executeUpdate();
            
            //ambil data
            getDataPeminjam();
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public void hapusDataPeminjam(){
        //panggil fungsi ambil data
        loadDataPeminjam();
        
        //Beri peringatan sebelum melakukan penghapusan data
        int pesan = JOptionPane.showConfirmDialog(null, "HAPUS DATA" + id_peminjam +"?","KONFIRMASI", JOptionPane.OK_CANCEL_OPTION);
        
        //jika pengguna memilih OK lanjutkan proses hapus data
        if(pesan == JOptionPane.OK_OPTION){
            //uji koneksi
            try{
                //buka koneksi ke database
                Statement stat = (Statement) koneksidb.getKoneksi().createStatement();
                
                //perintah hapus data
                String sql = "DELETE FROM peminjaman WHERE id_peminjam='"+ id_peminjam +"'";
                PreparedStatement p =(PreparedStatement)koneksidb.getKoneksi().prepareStatement(sql);
                p.executeUpdate();
                
                //fungsi reset data
                reset();
                
                getDataPeminjam();
                JOptionPane.showMessageDialog(null, "DATA BERHASIL DIHAPUS");
            }catch(SQLException err){
                JOptionPane.showMessageDialog(null, err.getMessage());
            }
        }
    }
    
    public void perbaruhiDataPeminjam(){
        //fungsi load data 
        loadDataPeminjam();
        
        try{
            //uji koneksi
            Statement stat = (Statement) koneksidb.getKoneksi().createStatement();
            
            //kirim perintah sql
            String sql = "UPDATE peminjaman SET id_petugas = '"+id_petugas +"',"
                    +"id_penyewa = '"+id_penyewa +"',"
                    +"id_kamera = '"+id_kamera +"',"
                    +"merk_kamera = '"+merk_kamera +"',"
                    +"tanggal_pinjam = '"+tanggal_pinjam +"',"
                    +"jaminan_pinjam = '"+jaminan_pinjam +"',"
                    +"harga_sewa = '"+harga_sewa +"'"
                    +"WHERE id_peminjam = '"+id_peminjam +"'";
            PreparedStatement p =(PreparedStatement)koneksidb.getKoneksi().prepareStatement(sql);
            p.executeUpdate();
            
            //ambil data
            getDataPeminjam();
            
            //kosongkan data
            reset();
            JOptionPane.showMessageDialog(null, "DATA BERHASIL DIHAPUS");
            }catch(SQLException err){
                JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    

    
    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        // TODO add your handling code here:
        simpanDataPeminjaman();
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bresetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_bresetActionPerformed

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_bkeluarActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
        hapusDataPeminjam();
    }//GEN-LAST:event_bhapusActionPerformed

    private void combo_idpetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_idpetugasActionPerformed
        // TODO add your handling code here:
        combo_idpetugas();
    }//GEN-LAST:event_combo_idpetugasActionPerformed

    private void txtnama_petugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnama_petugasActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtnama_petugasActionPerformed

    private void idpenyewaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_idpenyewaItemStateChanged
        // TODO add your handling code here:
        dataPenyewa();
    }//GEN-LAST:event_idpenyewaItemStateChanged

    private void combo_idpetugasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_idpetugasItemStateChanged
        // TODO add your handling code here:
        dataPetugas();
    }//GEN-LAST:event_combo_idpetugasItemStateChanged

    private void idkameraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_idkameraItemStateChanged
        // TODO add your handling code here:
        dataProduk();
    }//GEN-LAST:event_idkameraItemStateChanged

    private void idpenyewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idpenyewaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_idpenyewaActionPerformed

    private void idkameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idkameraActionPerformed
        // TODO add your handling code here:
        combo_idkamera();
    }//GEN-LAST:event_idkameraActionPerformed

    private void bubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubahActionPerformed
        // TODO add your handling code here:
        perbaruhiDataPeminjam();
    }//GEN-LAST:event_bubahActionPerformed

    private void txtnama_penyewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnama_penyewaActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txtnama_penyewaActionPerformed

    private void tmerkkameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tmerkkameraActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tmerkkameraActionPerformed

    private void tabeltransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeltransaksiMouseClicked
        // TODO add your handling code here:
        dataSelect();
    }//GEN-LAST:event_tabeltransaksiMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(formTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton breset;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton bubah;
    private javax.swing.JComboBox<String> combo_idpetugas;
    private javax.swing.JComboBox<String> idkamera;
    private javax.swing.JComboBox<String> idpenyewa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabeltransaksi;
    private javax.swing.JTextField thargasewa;
    private javax.swing.JTextField tidpinjam;
    private javax.swing.JTextField tjaminan;
    private javax.swing.JTextField tmerkkamera;
    private javax.swing.JFormattedTextField ttanggalpinjam;
    private javax.swing.JTextField txtnama_penyewa;
    private javax.swing.JTextField txtnama_petugas;
    // End of variables declaration//GEN-END:variables
}
