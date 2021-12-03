/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Dao.KhachHangDao;
import Data.DataValdator;
import Data.MessageDialogHelper;
import Model.KhachHang;

/**
 *
 * @author 54321
 */
public class KhachHangView extends javax.swing.JPanel {
    private List<KhachHang> kh;
    private MenuView menuView;
    private DefaultTableModel tblModel = new DefaultTableModel();
    /**
     * Creates new form KhachHangView
     */
    public KhachHangView() {
        initComponents();
        initTable();
        LoadDataTable();
    }
private  void LoadDataTable()
    {
       try
       {
           KhachHangDao dao = new KhachHangDao();
           List<KhachHang> list =dao.findAll();  
           tblModel.setRowCount(0);
          for(KhachHang it : list) {
               tblModel.addRow(new Object[]
               {
                   it.getMakh(), it.getHoten(), it.getNgaysinh(),it.getSdt(),it.getCmdn(),it.getEmail(), it.getDiachi()
               });
          }
          tblModel.fireTableDataChanged();                          
       }
       catch ( Exception e)     
       {
           e.printStackTrace();
           MessageDialogHelper.showErrorDialog(menuView,e.getMessage(),"Lỗi!");
       }          
    }
     // ten bnsg
    private void initTable()
    {   
        tblModel = new DefaultTableModel();
        String[] columns = new String[]{"Mã khách hàng " ,"Họ Tên ", "Ngày sinh","Số ĐT","Số CMND"," Email","Địa chỉ"};
        tblModel.setColumnIdentifiers(columns);
        tblkhachhang.setModel(tblModel);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnThemXuat1 = new javax.swing.JButton();
        btnSuaXuat1 = new javax.swing.JButton();
        btnResetXuat1 = new javax.swing.JButton();
        btnXoaXuat1 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtMaKH1 = new javax.swing.JTextField();
        txtHoTen1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtSoDT1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCMND1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaDiaChi = new javax.swing.JTextArea();
        txtNgaysinh = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblkhachhang = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btntimkiemMaKH1 = new javax.swing.JButton();

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức Năng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N

        btnThemXuat1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemXuat1.setForeground(new java.awt.Color(0, 153, 0));
        btnThemXuat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnThemXuat1.setText("Thêm");
        btnThemXuat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemXuat1ActionPerformed(evt);
            }
        });

        btnSuaXuat1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSuaXuat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Actions-document-edit-icon-16.png"))); // NOI18N
        btnSuaXuat1.setText("Sửa");
        btnSuaXuat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaXuat1ActionPerformed(evt);
            }
        });

        btnResetXuat1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnResetXuat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_refresh_15px.png"))); // NOI18N
        btnResetXuat1.setText("Reset");
        btnResetXuat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetXuat1ActionPerformed(evt);
            }
        });

        btnXoaXuat1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoaXuat1.setForeground(new java.awt.Color(204, 0, 0));
        btnXoaXuat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Actions-edit-delete-icon-16.png"))); // NOI18N
        btnXoaXuat1.setText("Xóa");
        btnXoaXuat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaXuat1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btnThemXuat1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(btnSuaXuat1)
                .addGap(88, 88, 88)
                .addComponent(btnResetXuat1)
                .addGap(68, 68, 68)
                .addComponent(btnXoaXuat1)
                .addGap(47, 47, 47))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaXuat1)
                    .addComponent(btnResetXuat1)
                    .addComponent(btnXoaXuat1)
                    .addComponent(btnThemXuat1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Khách Hàng"));

        jLabel10.setText("Mã khách hàng");

        txtMaKH1.setEditable(false);

        jLabel11.setText("Họ tên");

        jLabel12.setText("Ngày sinh");

        jLabel13.setText("Số điện thoại");

        jLabel14.setText("Số CMND");

        jLabel15.setText("Email");

        jLabel16.setText("Đia Chỉ");

        txaDiaChi.setColumns(20);
        txaDiaChi.setRows(5);
        jScrollPane3.setViewportView(txaDiaChi);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(txtMaKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtEmail)
                    .addComponent(txtCMND1)
                    .addComponent(txtSoDT1)
                    .addComponent(txtNgaysinh)
                    .addComponent(txtHoTen1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(txtMaKH1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHoTen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(txtSoDT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(txtCMND1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(63, 63, 63)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        tblkhachhang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblkhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblkhachhangMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblkhachhang);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Danh Sách Khách Hàng");

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(153, 0, 153))); // NOI18N

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel20.setText("Tên Khách Hàng");

        btntimkiemMaKH1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search-icon-24.png"))); // NOI18N
        btntimkiemMaKH1.setText("Tìm Kiếm");
        btntimkiemMaKH1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemMaKH1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btntimkiemMaKH1, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem)
                    .addComponent(jLabel20)
                    .addComponent(btntimkiemMaKH1))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(185, 185, 185)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(98, 98, 98))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaXuat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaXuat1ActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValdator.CheckDL(txtMaKH1, sb, "Mã khách hàng không được để trống !");

        if( sb.length()>0)
        {
            MessageDialogHelper.showErrorDialog(this,sb.toString(), "Lỗi");
            return;
        }
        if(MessageDialogHelper.showConfirmDialog(menuView,"Bạn có muốn xóa khách hàng không","Hỏi?")== JOptionPane.NO_OPTION)
        {
            return;
        }
        try
        {

            KhachHangDao dao = new KhachHangDao();
            if(dao.delete(Integer.parseInt(txtMaKH1.getText())))
            {
                MessageDialogHelper.showMessageDialog(menuView, "Khách hàng đã đươc xóa!", "Thông báo !");
                //                btnluuActionPerformed(evt);
                LoadDataTable();
            }
            else
            {
                MessageDialogHelper.showConfirmDialog(menuView, "Khách hàng không được xóa !","Cảnh báo!");
            }

        }
        catch( Exception e)
        {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView,e.getMessage(),"Lỗi!");
        }
    }//GEN-LAST:event_btnXoaXuat1ActionPerformed

    private void btnResetXuat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetXuat1ActionPerformed
        txtMaKH1.setText("");
        txtHoTen1.setText("");
        txtNgaysinh.setText("");
        txtSoDT1.setText("");
        txtCMND1.setText("");
        txtEmail.setText("");
        txaDiaChi.setText("");
        LoadDataTable();
    }//GEN-LAST:event_btnResetXuat1ActionPerformed

    private void btnSuaXuat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaXuat1ActionPerformed
        StringBuilder sb = new StringBuilder();
//        DataValdator.CheckDL(txtMaKH1, sb, "Mã khách hàng không được để trống !");
        DataValdator.CheckDL(txtHoTen1, sb, "Tên khách hàng không được để trống !");
        if( sb.length()>0)
        {
            MessageDialogHelper.showErrorDialog(this,sb.toString(), "Lỗi");
            return;
        }
        if(MessageDialogHelper.showConfirmDialog(menuView,"Bạn có muốn cập nhật nhân viên không","Hỏi?")== JOptionPane.NO_OPTION)
        {
            return;
        }
        try
        {
            KhachHang kh = new KhachHang();
            kh.setMakh(Integer.parseInt(txtMaKH1.getText()));
            kh.setHoten(txtHoTen1.getText());
            kh.setNgaysinh(txtNgaysinh.getText());
            kh.setSdt(txtSoDT1.getText());
            kh.setCmdn(txtCMND1.getText());
            kh.setEmail(txtEmail.getText());
            kh.setDiachi(txaDiaChi.getText());

            KhachHangDao dao = new KhachHangDao();
            if(dao.update(kh))
            {
                MessageDialogHelper.showMessageDialog(menuView, "Khách hàng đã đươc cập nhật", "Thông báo !");
                LoadDataTable();
            }
            else
            {
                MessageDialogHelper.showConfirmDialog(menuView, "Khách hàng không được cập nhật do lỗi !","Cảnh báo!");
               
            }

        }
        catch( Exception e)
        {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView,e.getMessage(),"Lỗi!");
        }
    }//GEN-LAST:event_btnSuaXuat1ActionPerformed

    private void btnThemXuat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemXuat1ActionPerformed
        StringBuilder sb = new StringBuilder();
//        DataValdator.CheckDL(txtMaKH1, sb, "Mã khách hàng không được để trống !");
        DataValdator.CheckDL(txtHoTen1, sb, "Tên khách hàng không được để trống !");
        if( sb.length()>0)
        {
            MessageDialogHelper.showErrorDialog(this,sb.toString(), "Lỗi");
            return;
        }
        try
        {
            KhachHang kh = new KhachHang();
//            kh.setMakh(Integer.parseInt(txtMaKH1.getText()));
            kh.setHoten(txtHoTen1.getText());
            kh.setNgaysinh(txtNgaysinh.getText());
            kh.setSdt(txtSoDT1.getText());
            kh.setCmdn(txtCMND1.getText());
            kh.setEmail(txtEmail.getText());
            kh.setDiachi(txaDiaChi.getText());

            KhachHangDao dao = new KhachHangDao();
            if(dao.insert(kh))
            {
                MessageDialogHelper.showMessageDialog(menuView, "Khách hàng đã đươc lưu", "Thông báo !");
                LoadDataTable();
            }
            else
            {
                MessageDialogHelper.showConfirmDialog(menuView, "Khách hàng không được lưu do lỗi !","Cảnh báo!");
            }

        }
        catch( Exception e)
        {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView,e.getMessage(),"Lỗi!");
        }
    }//GEN-LAST:event_btnThemXuat1ActionPerformed

    private void btntimkiemMaKH1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemMaKH1ActionPerformed
        String tim=txtTimKiem.getText();
       if(tim.length()>0){
           try{
               kh=new KhachHangDao().findTenKH(tim);
               
           }catch(Exception e){
               e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
            
           }
           
           tblModel.setRowCount(0);
            for (KhachHang it : kh) {
                tblModel.addRow(new Object[]{
                   it.getMakh(), it.getHoten(), it.getNgaysinh(),it.getSdt(),it.getCmdn(),it.getEmail(), it.getDiachi()
               });
            }
            tblModel.fireTableDataChanged();
           
           
       }
       
       
    }//GEN-LAST:event_btntimkiemMaKH1ActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void tblkhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblkhachhangMouseClicked
        try{
            int row=tblkhachhang.getSelectedRow();
            if(row>=0){
                Integer id=(Integer) tblkhachhang.getValueAt(row, 0);
                KhachHangDao dao=new KhachHangDao();
                KhachHang kh=dao.findDung(id);
                if(kh!=null){
                    txtMaKH1.setText("" +kh.getMakh());
                    txtHoTen1.setText(kh.getHoten());
                    txtNgaysinh.setText(kh.getNgaysinh());
                    txtSoDT1.setText(kh.getSdt());
                    txtCMND1.setText(kh.getCmdn());
                    txtEmail.setText(kh.getEmail());
                    txaDiaChi.setText(kh.getDiachi());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi");
        
        }
    }//GEN-LAST:event_tblkhachhangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnResetXuat1;
    private javax.swing.JButton btnSuaXuat1;
    private javax.swing.JButton btnThemXuat1;
    private javax.swing.JButton btnXoaXuat1;
    private javax.swing.JButton btntimkiemMaKH1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblkhachhang;
    private javax.swing.JTextArea txaDiaChi;
    private javax.swing.JTextField txtCMND1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen1;
    private javax.swing.JTextField txtMaKH1;
    private javax.swing.JTextField txtNgaysinh;
    private javax.swing.JTextField txtSoDT1;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}