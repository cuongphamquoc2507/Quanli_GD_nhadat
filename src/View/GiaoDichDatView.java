/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.DatDao;
import Dao.GiaoDichDatDao;
import Dao.KhachHangDao;
import Data.DataValdator;
import Data.DatabaseHelper;
import Data.ImageHelper;
import Data.MessageDialogHelper;
import Model.Dat;
import Model.GiaoDichDat;
import Model.KhachHang;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author This PC
 */
public class GiaoDichDatView extends javax.swing.JPanel {
    private List<GiaoDichDat> gdat;
private MenuView menuView;
    private DefaultTableModel tblModel = new DefaultTableModel();
    private DefaultTableModel tblModel1 = new DefaultTableModel();
    private byte[] personalImage;
    /**
     * Creates new form DatView
     */
    public GiaoDichDatView() throws Exception {
        initComponents();
        initComponents();
        initTable();
        LoaiDat();
        TrangThai();
        initCombobox();
        LoadDataTable();
        initTable1();
        LoadDataTable1();
        initCombobox1();
        initCombobox2();

        txtNgayGD.setDateFormatString("dd/MM/yyyy");
    }
private void initCombobox() throws Exception {
        KhachHangDao dao = new KhachHangDao();
        List<KhachHang> list = dao.findAll();

        String sql = "SELECT MaKH FROM KhachHang";
        {
            Connection con = DatabaseHelper.openConnection();

            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            txtmakh.removeAllItems();
            while (rs.next()) {
                txtmakh.addItem(rs.getString("MaKH"));
            }
            rs.close();
            pstmt.close();
            con.close();
        }
    }

    private void initCombobox1() throws Exception {

        String sql = "SELECT MaDat from DAT";
        {
            Connection con = DatabaseHelper.openConnection();

            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            txtmadat.removeAllItems();
            while (rs.next()) {
                txtmadat.addItem(rs.getString("MaDat"));

            }
            rs.close();
            pstmt.close();
            con.close();

        }

    }

    private void initCombobox2() throws Exception {

        String sql = "SELECT MaND from NGUOIDUNG";
        {
            Connection con = DatabaseHelper.openConnection();

            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            txtxngtao.removeAllItems();
            while (rs.next()) {
                txtxngtao.addItem(rs.getString("MaND"));
            }
            rs.close();
            pstmt.close();
            con.close();
        }

    }

    private void LoaiDat() {
        String[] LoaiDat = new String[]{
            "A", "B", " C "
        };
        DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<>(LoaiDat);
        this.txtloaidat.setModel(boxModel);
    }

    private void TrangThai() {
        String[] TrangThai = new String[]{
            "Đã bán", "Chưa bán"
        };
        DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<>(TrangThai);
        this.txttrangthai.setModel(boxModel);
    }

    private void LoadDataTable1() {
        try {
            DatDao dao = new DatDao();
            List<Dat> list = dao.findAll1();
            tblModel1.setRowCount(0);
            for (Dat it : list) {
                tblModel1.addRow(new Object[]{
                    it.getMaDat(), it.getLoaiDat(), it.getDonGia(),
                    it.getDienTich(), it.getTrangThai()

                });
            }
            tblModel1.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
        }
    }
    // ten bnsg

    private void initTable1() {
        tblModel1 = new DefaultTableModel();
        String[] columns = new String[]{"Mã đất", "Loai Đất ", "Đơn Giá", "Diện tích ", "Trạng thái"};
        tblModel1.setColumnIdentifiers(columns);
        tbbang2.setModel(tblModel1);

    }

    private void LoadDataTable() {
        try {
            GiaoDichDatDao dao = new GiaoDichDatDao();
            List<GiaoDichDat> list = dao.findAll();
            tblModel.setRowCount(0);
            for (GiaoDichDat it : list) {
                tblModel.addRow(new Object[]{
                    it.getMaGDD(), it.getNgayGD(), it.getMaDat(),
                    it.getMaKH(),
                    it.getMaND(), it.getThanhToan()
                });
            }
            tblModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
        }
    }
    // ten bnsg

    private void initTable() {
        tblModel = new DefaultTableModel();
        String[] columns = new String[]{"Mã GD", "Ngay GD", "Mã đất", "Khách hàng", "Người tạo", "Thành Tiền"};
        tblModel.setColumnIdentifiers(columns);
        tbbang1.setModel(tblModel);

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtmadat1 = new javax.swing.JTextField();
        txtloaidat = new javax.swing.JComboBox<>();
        txtdonngia = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lbanh = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnhinh1 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        txtdt = new javax.swing.JFormattedTextField();
        txttrangthai = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbbang2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnThemXuat2 = new javax.swing.JButton();
        btnSuaXuat2 = new javax.swing.JButton();
        btnResetXuat2 = new javax.swing.JButton();
        btnXoaXuat2 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        txtTimLoaidat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btntimkiem = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtmagd = new javax.swing.JTextField();
        txtmadat = new javax.swing.JComboBox<>();
        txtmakh = new javax.swing.JComboBox<>();
        txtxngtao = new javax.swing.JComboBox<>();
        lb_Amount = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtloaidat1 = new javax.swing.JTextField();
        txtdongia1 = new javax.swing.JTextField();
        txtdientich1 = new javax.swing.JTextField();
        lbtien = new javax.swing.JLabel();
        txt_Price = new javax.swing.JTextField();
        txtNgayGD = new com.toedter.calendar.JDateChooser();
        lblanh2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        btnthanhtoan = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbbang1 = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        txtTimNgay = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        btntimkiem1 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        btnThemXuat3 = new javax.swing.JButton();
        btnSuaXuat3 = new javax.swing.JButton();
        btnResetXuat3 = new javax.swing.JButton();
        btnXoaXuat3 = new javax.swing.JButton();
        lblanh1 = new javax.swing.JLabel();

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel2.setLayout(null);

        jPanel3.setLayout(null);

        jLabel1.setText("Mã Đất");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(10, 25, 60, 14);

        jLabel2.setText("Loại Đất");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(10, 80, 70, 14);

        jLabel3.setText("Đơn Giá");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(10, 120, 60, 20);

        txtmadat1.setEditable(false);
        txtmadat1.setVerifyInputWhenFocusTarget(false);
        jPanel3.add(txtmadat1);
        txtmadat1.setBounds(80, 22, 140, 30);

        txtloaidat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtloaidat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtloaidatActionPerformed(evt);
            }
        });
        jPanel3.add(txtloaidat);
        txtloaidat.setBounds(80, 70, 140, 30);

        txtdonngia.setEditable(false);
        jPanel3.add(txtdonngia);
        txtdonngia.setBounds(80, 120, 140, 30);

        lbanh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images.png"))); // NOI18N
        lbanh.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbanh, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbanh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4);
        jPanel4.setBounds(10, 260, 300, 160);

        jLabel4.setText("Diện Tích");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(10, 170, 70, 30);

        btnhinh1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/open-file-icon-16.png"))); // NOI18N
        btnhinh1.setText("Mở Hình");
        btnhinh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhinh1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnhinh1);
        btnhinh1.setBounds(200, 460, 100, 25);

        jLabel20.setText("Trạng Thái");
        jPanel3.add(jLabel20);
        jLabel20.setBounds(10, 220, 70, 14);
        jPanel3.add(txtdt);
        txtdt.setBounds(80, 180, 140, 30);

        txttrangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(txttrangthai);
        txttrangthai.setBounds(80, 220, 130, 30);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 51, 51));
        jLabel21.setText("VNĐ");
        jPanel3.add(jLabel21);
        jLabel21.setBounds(230, 120, 25, 30);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 51, 51));
        jLabel22.setText("m2");
        jPanel3.add(jLabel22);
        jLabel22.setBounds(230, 180, 50, 20);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(10, 90, 330, 490);

        tbbang2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbbang2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbbang2);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 204));
        jLabel6.setText("Danh sách đất");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(348, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(275, 275, 275))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        jPanel2.add(jPanel5);
        jPanel5.setBounds(380, 90, 830, 320);

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức Năng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N

        btnThemXuat2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemXuat2.setForeground(new java.awt.Color(0, 153, 0));
        btnThemXuat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnThemXuat2.setText("Thêm");
        btnThemXuat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemXuat2ActionPerformed(evt);
            }
        });

        btnSuaXuat2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSuaXuat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Actions-document-edit-icon-16.png"))); // NOI18N
        btnSuaXuat2.setText("Sửa");
        btnSuaXuat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaXuat2ActionPerformed(evt);
            }
        });

        btnResetXuat2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnResetXuat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_refresh_15px.png"))); // NOI18N
        btnResetXuat2.setText("Reset");
        btnResetXuat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetXuat2ActionPerformed(evt);
            }
        });

        btnXoaXuat2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoaXuat2.setForeground(new java.awt.Color(204, 0, 0));
        btnXoaXuat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Actions-edit-delete-icon-16.png"))); // NOI18N
        btnXoaXuat2.setText("Xóa");
        btnXoaXuat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaXuat2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnThemXuat2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(btnSuaXuat2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(btnResetXuat2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(btnXoaXuat2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemXuat2)
                    .addComponent(btnSuaXuat2)
                    .addComponent(btnResetXuat2)
                    .addComponent(btnXoaXuat2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel8);
        jPanel8.setBounds(380, 390, 820, 80);

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(153, 0, 153))); // NOI18N

        txtTimLoaidat.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtTimLoaidat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimLoaidatKeyReleased(evt);
            }
        });

        jLabel8.setText("Mã đất");

        btntimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search-icon-24.png"))); // NOI18N
        btntimkiem.setText("Tìm Kiếm");
        btntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtTimLoaidat, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btntimkiem)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimLoaidat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );

        jPanel2.add(jPanel17);
        jPanel17.setBounds(10, 10, 560, 70);

        jTabbedPane1.addTab("Danh Mục Đất", jPanel2);

        jPanel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Mã Giao Dịch");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Ngày Giao Dịch");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Mã Đất");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("Khách Hàng");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setText("Người Tạo");

        txtmagd.setEditable(false);

        txtmadat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtmadat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtmadatFocusLost(evt);
            }
        });
        txtmadat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmadatActionPerformed(evt);
            }
        });

        txtmakh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtmakh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmakhActionPerformed(evt);
            }
        });

        txtxngtao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lb_Amount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_Amount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Loai Đất");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("Đơn Giá");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("Diện Tích");

        txtloaidat1.setEditable(false);

        txtdongia1.setEditable(false);
        txtdongia1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtdongia1FocusLost(evt);
            }
        });

        txtdientich1.setEditable(false);
        txtdientich1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdientich1ActionPerformed(evt);
            }
        });

        lbtien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbtien.setForeground(new java.awt.Color(255, 102, 102));
        lbtien.setText("1000000");

        txt_Price.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_Price.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Price.setText("VNĐ");
        txt_Price.setBorder(null);
        txt_Price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PriceActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("VNĐ");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 51));
        jLabel16.setText("m2");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_money_25px.png"))); // NOI18N
        jLabel17.setText("Thanh Toán");

        btnthanhtoan.setText("Thanh Toán");
        btnthanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthanhtoanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lb_Amount, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(lblanh2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(225, 225, 225))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtloaidat1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmadat, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNgayGD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(txtmagd, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(127, 127, 127))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(29, 29, 29)
                                        .addComponent(txtdientich1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(49, 49, 49)
                                        .addComponent(txtdongia1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtxngtao, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtmakh, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbtien, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(txt_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(btnthanhtoan)
                                .addGap(71, 71, 71)))
                        .addGap(0, 70, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtmagd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgayGD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmadat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtloaidat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtdongia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtdientich1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtmakh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(txtxngtao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(lb_Amount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtien, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnthanhtoan)
                .addGap(27, 27, 27)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblanh2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(225, 225, 225))
        );

        jPanel1.add(jPanel9);
        jPanel9.setBounds(10, 70, 438, 540);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Danh sách giao dich");

        tbbang1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbbang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbbang1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbbang1);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(318, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(236, 236, 236))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel11);
        jPanel11.setBounds(513, 11, 730, 295);

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(153, 0, 153))); // NOI18N

        txtTimNgay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimNgayKeyReleased(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setText("Ngày Giao Dịch");

        btntimkiem1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btntimkiem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search-icon-24.png"))); // NOI18N
        btntimkiem1.setText("Tìm Kiếm");
        btntimkiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiem1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(txtTimNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btntimkiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btntimkiem1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimNgay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel18);
        jPanel18.setBounds(10, 0, 490, 70);

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức Năng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N

        btnThemXuat3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnThemXuat3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnThemXuat3.setText("Thêm");
        btnThemXuat3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemXuat3ActionPerformed(evt);
            }
        });

        btnSuaXuat3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSuaXuat3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Actions-document-edit-icon-16.png"))); // NOI18N
        btnSuaXuat3.setText("Sửa");
        btnSuaXuat3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaXuat3ActionPerformed(evt);
            }
        });

        btnResetXuat3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnResetXuat3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_refresh_15px.png"))); // NOI18N
        btnResetXuat3.setText("Reset");
        btnResetXuat3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetXuat3ActionPerformed(evt);
            }
        });

        btnXoaXuat3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnXoaXuat3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png"))); // NOI18N
        btnXoaXuat3.setText("Xóa");
        btnXoaXuat3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaXuat3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemXuat3)
                    .addComponent(btnResetXuat3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSuaXuat3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaXuat3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemXuat3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaXuat3))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResetXuat3)
                    .addComponent(btnXoaXuat3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel12);
        jPanel12.setBounds(859, 317, 309, 116);

        lblanh1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tải xuống2.png"))); // NOI18N
        lblanh1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblanh1);
        lblanh1.setBounds(520, 310, 260, 170);

        jTabbedPane1.addTab("Giao Dịch Đất", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1262, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtloaidatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtloaidatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtloaidatActionPerformed

    private void btnhinh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhinh1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileFilter() {
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".jpg");
                }
            }

            @Override
            public String getDescription() {
                return " Image File (*.jpg)";
            }
        });
        // hop thoai
        if (chooser.showOpenDialog(menuView) == JFileChooser.CANCEL_OPTION) {
            return;
        }
        File file = chooser.getSelectedFile();
        try {
            ImageIcon icon = new ImageIcon(file.getPath());
            Image img = ImageHelper.resize(icon.getImage(), 250, 150);
            ImageIcon resiIcon = new ImageIcon(img);
            lbanh.setIcon(resiIcon);
            //luu vao CSDL
            personalImage = ImageHelper.toByteArray(img, "jpg");
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
        }
    }//GEN-LAST:event_btnhinh1ActionPerformed

    private void tbbang2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbang2MouseClicked
        try {
            int row = tbbang2.getSelectedRow();
            if (row >= 0) {
                Integer id = (int) tbbang2.getValueAt(row, 0);
                DatDao dao = new DatDao();
                Dat sv = dao.findDat1(id);
                if (sv != null) {
                    txtmadat1.setText("" +sv.getMaDat());
                    txtloaidat.setSelectedItem(sv.getLoaiDat());
                    txtdonngia.setText("" + sv.getDonGia());
                    txtdt.setText("" + sv.getDienTich());
                    txttrangthai.setSelectedItem(sv.getTrangThai());
                    if (sv.getMota() != null) {
                        Image img = ImageHelper.createiImage(sv.getMota(), "jpg");
                        lbanh.setIcon(new ImageIcon(img));
                        personalImage = sv.getMota();
                    } else {
                        personalImage = sv.getMota();
                        ImageIcon icon = new ImageIcon(
                            getClass().getResource(""));
                        lbanh.setIcon(icon);
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
        }
    }//GEN-LAST:event_tbbang2MouseClicked

    private void btnThemXuat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemXuat2ActionPerformed
        StringBuilder sb = new StringBuilder();
//        DataValdator.CheckDL(txtmadat1, sb, "Mã đất không được để trống !");

        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(this, sb.toString(), "Lỗi");
            return;
        }
        try {
            Dat d = new Dat();
//            d.setMaDat(Integer.parseInt(txtmadat1.getText()));
            d.setLoaiDat(txtloaidat.getSelectedItem().toString());
            // d.setDonGia(Float.parseFloat(txtdonngia.getText()));
            d.setDienTich(Float.parseFloat(txtdt.getText()));
            d.setTrangThai(txttrangthai.getSelectedItem().toString());
            d.setMota(personalImage);

            txtmadatFocusLost(null);
            DatDao dao = new DatDao();
            if (dao.insert(d)) {
                MessageDialogHelper.showMessageDialog(menuView, "Mục đất đã đươc lưu", "Thông báo !");
                LoadDataTable1();
                 txtmadatFocusLost(null);
            } else {
                MessageDialogHelper.showConfirmDialog(menuView, "Mục đất không được lưu do lỗi !", "Cảnh báo!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showConfirmDialog(menuView, "Mã đất đã tồn tại , vui lòng nhập mã mới!", "Cảnh báo!");
        }
    }//GEN-LAST:event_btnThemXuat2ActionPerformed

    private void btnSuaXuat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaXuat2ActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValdator.CheckDL(txtmadat1, sb, "Mã dất không được để trống !");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(this, sb.toString(), "Lỗi");
            return;
        }
        if (MessageDialogHelper.showConfirmDialog(menuView, "Bạn có muốn cập nhật mục đất không", "Hỏi?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            Dat d = new Dat();
            d.setMaDat(Integer.parseInt(txtmadat1.getText()));
            d.setLoaiDat(txtloaidat.getSelectedItem().toString());
            //d.setDonGia(Float.parseFloat(txtdonngia.getText()));
            d.setDienTich(Float.parseFloat(txtdt.getText()));
            d.setTrangThai(txttrangthai.getSelectedItem().toString());
            d.setMota(personalImage);

            DatDao dao = new DatDao();
            if (dao.update(d)) {
                MessageDialogHelper.showMessageDialog(menuView, "Ma đất đã đươc cập nhật!", "Thông báo !");
                LoadDataTable1();
            } else {
                MessageDialogHelper.showConfirmDialog(menuView, "Mã dât không được cập nhật do lỗi !", "Cảnh báo!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
        }
    }//GEN-LAST:event_btnSuaXuat2ActionPerformed

    private void btnResetXuat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetXuat2ActionPerformed
        txtmadat1.setText("");
        txtdonngia.setText("");
        txtdt.setText("");

    }//GEN-LAST:event_btnResetXuat2ActionPerformed

    private void btnXoaXuat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaXuat2ActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValdator.CheckDL(txtmadat1, sb, "Mã đất không được để trống !");

        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(this, sb.toString(), "Lỗi");
            return;
        }
        if (MessageDialogHelper.showConfirmDialog(menuView, "Bạn có muốn xóa mã đất này không", "Hỏi?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            DatDao dao = new DatDao();
            if (dao.delete(Integer.parseInt(txtmadat1.getText()))) {
                MessageDialogHelper.showMessageDialog(menuView, "Mã đất đã đươc xóa!", "Thông báo !");

                LoadDataTable1();
            } else {
                MessageDialogHelper.showConfirmDialog(menuView, "Mã đất không được xóa !", "Cảnh báo!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
        }
    }//GEN-LAST:event_btnXoaXuat2ActionPerformed

    private void txtTimLoaidatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimLoaidatKeyReleased

    }//GEN-LAST:event_txtTimLoaidatKeyReleased

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
        try {
            DatDao dao = new DatDao();
            Dat d = dao.findDat1(Integer.parseInt(txtTimLoaidat.getText()));
            if (d != null) {
                txtmadat1.setText("" +d.getMaDat());
                txtloaidat.setSelectedItem(d.getLoaiDat());
                txtdonngia.setText("" + d.getDonGia());
                txtdt.setText("" + d.getDienTich());
                txttrangthai.setSelectedItem(d.getTrangThai());
                if (d.getMota() != null) {
                    Image img = ImageHelper.createiImage(d.getMota(), "jpg");
                    lbanh.setIcon(new ImageIcon(img));
                    personalImage = d.getMota();
                } else {
                    personalImage = d.getMota();
                    ImageIcon icon = new ImageIcon(
                        getClass().getResource(""));
                    lbanh.setIcon(icon);
                }
                LoadDataTable();
            } else {
                MessageDialogHelper.showMessageDialog(menuView,
                    "Không tim thấy đất can tim -_- ", "Thông báo !");
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
        }
    }//GEN-LAST:event_btntimkiemActionPerformed

    private void txtmadatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtmadatFocusLost
        try {
            DatDao dao = new DatDao();
            Dat d = dao.findDat1(Integer.parseInt(txtmadat.getSelectedItem().toString()));
            if (d != null) {
                txtloaidat1.setText(d.getLoaiDat());
                txtdongia1.setText(" " + d.getDonGia());
                txtdientich1.setText(" " + d.getDienTich());
                if (d.getMota() != null) {
                    Image img = ImageHelper.createiImage(d.getMota(), "jpg");
                    lblanh1.setIcon(new ImageIcon(img));
                    personalImage = d.getMota();
                } else {
                    personalImage = d.getMota();
                    ImageIcon icon = new ImageIcon(
                        getClass().getResource(""));
                    lblanh1.setIcon(icon);
                }
                

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtmadatFocusLost

    private void txtmadatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmadatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmadatActionPerformed

    private void txtmakhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmakhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmakhActionPerformed

    private void txtdongia1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdongia1FocusLost
        if (txtdientich1.getText().equals("")
            || txtdongia1.getText().equals("")
            || txtloaidat1.getText().equals("")) {
            return;
        }

        float s = Float.parseFloat(txtdientich1.getText());
        float gia = Float.parseFloat(txtdongia1.getText());
        String l = (txtloaidat1.getText());
        if ("A".equals(l)) {
            float thanhtien = (float) (s * gia * 1.5);
            String st = String.format("%.2f", thanhtien);
            lbtien.setText(st);
        } else {
            float thanhtien = (float) (s * gia);
            String st = String.format("%.2f", thanhtien);
            lbtien.setText(st);
        }
    }//GEN-LAST:event_txtdongia1FocusLost

    private void txtdientich1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdientich1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdientich1ActionPerformed

    private void txt_PriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PriceActionPerformed

    private void btnthanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthanhtoanActionPerformed
        if (txtdientich1.getText().equals("")
            || txtdongia1.getText().equals("")
            || txtloaidat1.getText().equals("")) {
            return;
        }

        float s = Float.parseFloat(txtdientich1.getText());
        float gia = Float.parseFloat(txtdongia1.getText());
        String l = (txtloaidat1.getText());
        if ("A".equals(l)) {
            float thanhtien = (float) (s * gia * 1.5);
            String st = String.format("%.2f", thanhtien);
            lbtien.setText(st);
        } else {
            float thanhtien = (float) (s * gia);
            String st = String.format("%.2f", thanhtien);
            lbtien.setText(st);
        }
    }//GEN-LAST:event_btnthanhtoanActionPerformed

    private void tbbang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbang1MouseClicked
        try {
            int row = tbbang1.getSelectedRow();
            if (row >= 0) {
                Integer id = (Integer) tbbang1.getValueAt(row, 0);

                GiaoDichDatDao dao = new GiaoDichDatDao();
                GiaoDichDat sv = dao.findDat(id);
                if (sv != null) {
                    txtmagd.setText("" +sv.getMaGDD());
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    txtNgayGD.setDate(sdf.parse(sv.getNgayGD()));
                    txtmadat.setSelectedItem(sv.getMaDat());
                    txtxngtao.setSelectedItem(sv.getMaND());
                    txtmakh.setSelectedItem(sv.getMaKH());
                    lbtien.setText(" " + sv.getThanhToan());
                    txtmadatFocusLost(null);

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
        }
    }//GEN-LAST:event_tbbang1MouseClicked

    private void txtTimNgayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimNgayKeyReleased

    }//GEN-LAST:event_txtTimNgayKeyReleased

    private void btntimkiem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiem1ActionPerformed
        String tim2=txtTimNgay.getText();
       if(tim2.length()>0){
           try{
               gdat=new GiaoDichDatDao().findbyDate(tim2);
           }catch(Exception e){
               e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
           }
           tblModel.setRowCount(0);
            for (GiaoDichDat it : gdat) {
                tblModel.addRow(new Object[]{
                    it.getMaGDD(), it.getNgayGD(), it.getMaDat(),
                    it.getMaKH(),it.getMaND(), it.getThanhToan()
                });
            }
            tblModel.fireTableDataChanged();
       }
    }//GEN-LAST:event_btntimkiem1ActionPerformed

    private void btnThemXuat3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemXuat3ActionPerformed
        StringBuilder sb = new StringBuilder();
//        DataValdator.CheckDL(txtmagd, sb, "Mã giao dich không được để trống !");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(this, sb.toString(), "Lỗi");
            return;
        }
        try {
            GiaoDichDat d = new GiaoDichDat();
//            d.setMaGDD(Integer.parseInt(txtmagd.getText()));
            SimpleDateFormat sf;
            sf = new SimpleDateFormat("yyyy-MM-dd");
            d.setNgayGD(sf.format(txtNgayGD.getDate()));
            d.setMaDat(txtmadat.getSelectedItem().toString());
            d.setMaKH(txtmakh.getSelectedItem().toString());
            d.setMaND(txtxngtao.getSelectedItem().toString());

            d.setThanhToan(Float.parseFloat(lbtien.getText()));

            txtmadatFocusLost(null);
            GiaoDichDatDao dao = new GiaoDichDatDao();
            if (dao.insert(d)) {
                MessageDialogHelper.showMessageDialog(menuView, "Giao dich đã đươc lưu", "Thông báo !");
                LoadDataTable();
            } else {
                MessageDialogHelper.showConfirmDialog(menuView, "Giao Dich không được lưu do lỗi !", "Cảnh báo!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
            //            MessageDialogHelper.showConfirmDialog(menuView, "Mã giao dịch đã tồn tại , vui lòng nhập mã mới !","Cảnh báo!");
        }
    }//GEN-LAST:event_btnThemXuat3ActionPerformed

    private void btnSuaXuat3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaXuat3ActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValdator.CheckDL(txtmagd, sb, "Mã giao dich không được để trống !");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(this, sb.toString(), "Lỗi");
            return;
        }
        if (MessageDialogHelper.showConfirmDialog(menuView, "Bạn có muốn cập nhật giao dich không", "Hỏi?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            GiaoDichDat d = new GiaoDichDat();
            d.setMaGDD(Integer.parseInt(txtmagd.getText()));
            SimpleDateFormat sf;
            sf = new SimpleDateFormat("yyyy-MM-dd");
            d.setNgayGD(sf.format(txtNgayGD.getDate()));
            d.setMaDat(txtmadat.getSelectedItem().toString());
            d.setMaKH(txtmakh.getSelectedItem().toString());
            d.setMaND(txtxngtao.getSelectedItem().toString());

            d.setThanhToan(Float.parseFloat(lbtien.getText()));
            txtmadatFocusLost(null);
            GiaoDichDatDao dao = new GiaoDichDatDao();
            if (dao.update(d)) {
                MessageDialogHelper.showMessageDialog(menuView, "Ma giao dich đã đươc cập nhật!", "Thông báo !");
                LoadDataTable();
            } else {
                MessageDialogHelper.showConfirmDialog(menuView, "Ma giao dich không được cập nhật do lỗi !", "Cảnh báo!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
        }
    }//GEN-LAST:event_btnSuaXuat3ActionPerformed

    private void btnResetXuat3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetXuat3ActionPerformed
        txtTimNgay.setText("");
        txtmagd.setText("");
        lb_Amount.setText("");
        txtdongia1.setText("");
        txtdientich1.setText("");
        txtloaidat1.setText("");
        lbtien.setText("");
        
        LoadDataTable();
    }//GEN-LAST:event_btnResetXuat3ActionPerformed

    private void btnXoaXuat3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaXuat3ActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValdator.CheckDL(txtmagd, sb, "Mã giao dich không được để trống !");

        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(this, sb.toString(), "Lỗi");
            return;
        }
        if (MessageDialogHelper.showConfirmDialog(menuView, "Bạn có muốn xóa giao dich không", "Hỏi?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            GiaoDichDatDao dao = new GiaoDichDatDao();
            if (dao.delete(Integer.parseInt(txtmagd.getText()))) {
                MessageDialogHelper.showMessageDialog(menuView, "Giao Dich đã đươc xóa!", "Thông báo !");

                LoadDataTable();
            } else {
                MessageDialogHelper.showConfirmDialog(menuView, "Giao dịch không được xóa !", "Cảnh báo!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
        }
    }//GEN-LAST:event_btnXoaXuat3ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        LoadDataTable();
    }//GEN-LAST:event_jTabbedPane1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnResetXuat2;
    private javax.swing.JButton btnResetXuat3;
    private javax.swing.JButton btnSuaXuat2;
    private javax.swing.JButton btnSuaXuat3;
    private javax.swing.JButton btnThemXuat2;
    private javax.swing.JButton btnThemXuat3;
    private javax.swing.JButton btnXoaXuat2;
    private javax.swing.JButton btnXoaXuat3;
    private javax.swing.JButton btnhinh1;
    private javax.swing.JButton btnthanhtoan;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JButton btntimkiem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lb_Amount;
    private javax.swing.JLabel lbanh;
    private javax.swing.JLabel lblanh1;
    private javax.swing.JLabel lblanh2;
    private javax.swing.JLabel lbtien;
    private javax.swing.JTable tbbang1;
    private javax.swing.JTable tbbang2;
    private com.toedter.calendar.JDateChooser txtNgayGD;
    private javax.swing.JTextField txtTimLoaidat;
    private javax.swing.JTextField txtTimNgay;
    private javax.swing.JTextField txt_Price;
    private javax.swing.JTextField txtdientich1;
    private javax.swing.JTextField txtdongia1;
    private javax.swing.JTextField txtdonngia;
    private javax.swing.JFormattedTextField txtdt;
    private javax.swing.JComboBox<String> txtloaidat;
    private javax.swing.JTextField txtloaidat1;
    private javax.swing.JComboBox<String> txtmadat;
    private javax.swing.JTextField txtmadat1;
    private javax.swing.JTextField txtmagd;
    private javax.swing.JComboBox<String> txtmakh;
    private javax.swing.JComboBox<String> txttrangthai;
    private javax.swing.JComboBox<String> txtxngtao;
    // End of variables declaration//GEN-END:variables
}
