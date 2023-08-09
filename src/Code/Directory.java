/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.text.JTextComponent;
/**
 *
 * @author ryoumen_kyoma
 */
public class Directory {
    JFileChooser selecfile;
    private File File;
    private final String[] options;
    private final String title;
    private final String extension;
    private final JFrame jframe;
    private final JTextComponent jTextComponent;
    
    public Directory(JFrame jframe, JTextComponent jtc, String string, String string1){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: aload_0
         * 1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         * 4: aload_0
         * 5: new           #2                  // class javax/swing/JFileChooser
         * 8: dup
         * 9: invokespecial #3                  // Method javax/swing/JFileChooser."<init>":()V
         * 12: putfield      #4                  // Field selecFile:Ljavax/swing/JFileChooser;
         * 15: aload_0
         * 16: iconst_2
         * 17: anewarray     #5                  // class java/lang/String
         * 20: dup
         * 21: iconst_0
         * 22: ldc           #6                  // String Guardar y continuar
         * 24: aastore
         * 25: dup
         * 26: iconst_1
         * 27: ldc           #7                  // String Descartar
         * 29: aastore
         * 30: putfield      #8                  // Field options:[Ljava/lang/String;
         * 33: aload_0
         * 34: aload_3
         * 35: putfield      #9                  // Field title:Ljava/lang/String;
         * 38: aload_0
         * 39: aload         4
         * 41: putfield      #10                 // Field extension:Ljava/lang/String;
         * 44: aload_0
         * 45: aload_1
         * 46: putfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 49: aload_0
         * 50: aload_2
         * 51: putfield      #12                 // Field jTextComponent:Ljavax/swing/text/JTextComponent;
         * 54: getstatic     #13                 // Field java/lang/System.out:Ljava/io/PrintStream;
         * 57: getstatic     #14                 // Field compilerTools/Functions.ANSI_PURPLE_BLACK:Ljava/lang/String;
         * 60: invokedynamic #15,  0             // InvokeDynamic #0:makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
         * 65: invokevirtual #16                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         * 68: return
         *  */
        // </editor-fold>
    }
    private void getTextFile(File file){
    // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: ldc           #17                 // String
         * 2: astore_2
         * 3: new           #18                 // class java/io/BufferedReader
         * 6: dup
         * 7: new           #19                 // class java/io/InputStreamReader
         * 10: dup
         * 11: new           #20                 // class java/io/FileInputStream
         * 14: dup
         * 15: aload_1
         * 16: invokespecial #21                 // Method java/io/FileInputStream."<init>":(Ljava/io/File;)V
         * 19: ldc           #22                 // String UTF8
         * 21: invokespecial #23                 // Method java/io/InputStreamReader."<init>":(Ljava/io/InputStream;Ljava/lang/String;)V
         * 24: invokespecial #24                 // Method java/io/BufferedReader."<init>":(Ljava/io/Reader;)V
         * 27: astore_3
         * 28: aload_3
         * 29: invokevirtual #25                 // Method java/io/BufferedReader.read:()I
         * 32: istore        4
         * 34: iload         4
         * 36: iconst_m1
         * 37: if_icmpeq     53
         * 40: aload_2
         * 41: iload         4
         * 43: i2c
         * 44: invokedynamic #26,  0             // InvokeDynamic #1:makeConcatWithConstants:(Ljava/lang/String;C)Ljava/lang/String;
         * 49: astore_2
         * 50: goto          28
         * 53: goto          92
         * 56: astore_3
         * 57: getstatic     #28                 // Field java/lang/System.err:Ljava/io/PrintStream;
         * 60: aload_3
         * 61: invokevirtual #29                 // Method java/io/FileNotFoundException.getMessage:()Ljava/lang/String;
         * 64: invokedynamic #30,  0             // InvokeDynamic #2:makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
         * 69: invokevirtual #16                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         * 72: aconst_null
         * 73: areturn
         * 74: astore_3
         * 75: getstatic     #28                 // Field java/lang/System.err:Ljava/io/PrintStream;
         * 78: aload_3
         * 79: invokevirtual #32                 // Method java/io/IOException.getMessage:()Ljava/lang/String;
         * 82: invokedynamic #33,  0             // InvokeDynamic #3:makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
         * 87: invokevirtual #16                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         * 90: aconst_null
         * 91: areturn
         * 92: aload_2
         * 93: areturn
         * Exception table:
         * from    to  target type
         * 3    53    56   Class java/io/FileNotFoundException
         * 3    53    74   Class java/io/IOException
         *  */
        // </editor-fold>
    }
    private void saveFile(File file, String string){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: new           #34                 // class java/io/FileOutputStream
         * 3: dup
         * 4: aload_1
         * 5: invokespecial #35                 // Method java/io/FileOutputStream."<init>":(Ljava/io/File;)V
         * 8: astore_3
         * 9: aload_2
         * 10: invokevirtual #36                 // Method java/lang/String.getBytes:()[B
         * 13: astore        4
         * 15: aload_3
         * 16: aload         4
         * 18: invokevirtual #37                 // Method java/io/FileOutputStream.write:([B)V
         * 21: goto          60
         * 24: astore_3
         * 25: getstatic     #28                 // Field java/lang/System.err:Ljava/io/PrintStream;
         * 28: aload_3
         * 29: invokevirtual #29                 // Method java/io/FileNotFoundException.getMessage:()Ljava/lang/String;
         * 32: invokedynamic #30,  0             // InvokeDynamic #2:makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
         * 37: invokevirtual #16                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         * 40: iconst_0
         * 41: ireturn
         * 42: astore_3
         * 43: getstatic     #28                 // Field java/lang/System.err:Ljava/io/PrintStream;
         * 46: aload_3
         * 47: invokevirtual #32                 // Method java/io/IOException.getMessage:()Ljava/lang/String;
         * 50: invokedynamic #38,  0             // InvokeDynamic #4:makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
         * 55: invokevirtual #16                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         * 58: iconst_0
         * 59: ireturn
         * 60: iconst_1
         * 61: ireturn
         * Exception table:
         * from    to  target type
         * 0    21    24   Class java/io/FileNotFoundException
         * 0    21    42   Class java/io/IOException
         *  */
        // </editor-fold>
    }
    private void saveEditNew(File file, JFileChooser jfc){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: aload_0
         * 1: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 4: invokevirtual #39                 // Method javax/swing/JFrame.getTitle:()Ljava/lang/String;
         * 7: aload_0
         * 8: getfield      #9                  // Field title:Ljava/lang/String;
         * 11: invokedynamic #40,  0             // InvokeDynamic #5:makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
         * 16: invokevirtual #41                 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
         * 19: ifeq          27
         * 22: iconst_0
         * 23: istore_3
         * 24: goto          52
         * 27: aload_0
         * 28: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 31: ldc           #42                 // String El archivo actual está siendo editado, ¿desea guardar los cambios?
         * 33: ldc           #43                 // String ¿Descartar edición?
         * 35: iconst_m1
         * 36: iconst_3
         * 37: aconst_null
         * 38: aload_0
         * 39: getfield      #8                  // Field options:[Ljava/lang/String;
         * 42: aload_0
         * 43: getfield      #8                  // Field options:[Ljava/lang/String;
         * 46: iconst_0
         * 47: aaload
         * 48: invokestatic  #44                 // Method javax/swing/JOptionPane.showOptionDialog:(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;IILjavax/swing/Icon;[Ljava/lang/Object;Ljava/lang/Object;)I
         * 51: istore_3
         * 52: iload_3
         * 53: ifne          330
         * 56: aload_2
         * 57: invokevirtual #45                 // Method javax/swing/JFileChooser.getSelectedFile:()Ljava/io/File;
         * 60: ifnull        96
         * 63: aload_0
         * 64: aload_1
         * 65: aload_0
         * 66: getfield      #12                 // Field jTextComponent:Ljavax/swing/text/JTextComponent;
         * 69: invokevirtual #46                 // Method javax/swing/text/JTextComponent.getText:()Ljava/lang/String;
         * 72: invokevirtual #47                 // Method saveFile:(Ljava/io/File;Ljava/lang/String;)Z
         * 75: istore        4
         * 77: iload         4
         * 79: ifeq          93
         * 82: aload_0
         * 83: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 86: aload_1
         * 87: invokevirtual #48                 // Method java/io/File.getName:()Ljava/lang/String;
         * 90: invokevirtual #49                 // Method javax/swing/JFrame.setTitle:(Ljava/lang/String;)V
         * 93: goto          330
         * 96: aload_0
         * 97: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 100: invokevirtual #39                 // Method javax/swing/JFrame.getTitle:()Ljava/lang/String;
         * 103: aload_0
         * 104: getfield      #9                  // Field title:Ljava/lang/String;
         * 107: invokedynamic #40,  0             // InvokeDynamic #5:makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
         * 112: invokevirtual #41                 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
         * 115: ifeq          306
         * 118: aload_0
         * 119: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 122: ldc           #50                 // String ¿Desea guardar el archivo actual?
         * 124: ldc           #51                 // String ¿Descartar edición de archivo nuevo?
         * 126: iconst_m1
         * 127: iconst_3
         * 128: aconst_null
         * 129: aload_0
         * 130: getfield      #8                  // Field options:[Ljava/lang/String;
         * 133: aload_0
         * 134: getfield      #8                  // Field options:[Ljava/lang/String;
         * 137: iconst_0
         * 138: aaload
         * 139: invokestatic  #44                 // Method javax/swing/JOptionPane.showOptionDialog:(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;IILjavax/swing/Icon;[Ljava/lang/Object;Ljava/lang/Object;)I
         * 142: istore        4
         * 144: iload         4
         * 146: ifne          301
         * 149: aload_2
         * 150: aload_0
         * 151: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 154: ldc           #52                 // String Guardar
         * 156: invokevirtual #53                 // Method javax/swing/JFileChooser.showDialog:(Ljava/awt/Component;Ljava/lang/String;)I
         * 159: ifne          303
         * 162: aload_2
         * 163: invokevirtual #45                 // Method javax/swing/JFileChooser.getSelectedFile:()Ljava/io/File;
         * 166: astore_1
         * 167: aload_1
         * 168: invokevirtual #48                 // Method java/io/File.getName:()Ljava/lang/String;
         * 171: astore        5
         * 173: aload         5
         * 175: aload_0
         * 176: getfield      #10                 // Field extension:Ljava/lang/String;
         * 179: invokevirtual #54                 // Method java/lang/String.endsWith:(Ljava/lang/String;)Z
         * 182: ifne          198
         * 185: aload         5
         * 187: aload_0
         * 188: getfield      #10                 // Field extension:Ljava/lang/String;
         * 191: invokedynamic #55,  0             // InvokeDynamic #1:makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
         * 196: astore        5
         * 198: aload_0
         * 199: aload         5
         * 201: invokevirtual #56                 // Method fileNameValid:(Ljava/lang/String;)Z
         * 204: ifeq          284
         * 207: aload_1
         * 208: invokevirtual #48                 // Method java/io/File.getName:()Ljava/lang/String;
         * 211: aload_0
         * 212: getfield      #10                 // Field extension:Ljava/lang/String;
         * 215: invokevirtual #54                 // Method java/lang/String.endsWith:(Ljava/lang/String;)Z
         * 218: ifne          242
         * 221: new           #57                 // class java/io/File
         * 224: dup
         * 225: aload_1
         * 226: invokevirtual #58                 // Method java/io/File.getAbsolutePath:()Ljava/lang/String;
         * 229: aload_0
         * 230: getfield      #10                 // Field extension:Ljava/lang/String;
         * 233: invokedynamic #55,  0             // InvokeDynamic #1:makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
         * 238: invokespecial #59                 // Method java/io/File."<init>":(Ljava/lang/String;)V
         * 241: astore_1
         * 242: aload_1
         * 243: invokevirtual #60                 // Method java/io/File.exists:()Z
         * 246: ifne          257
         * 249: aload_0
         * 250: aload_1
         * 251: invokevirtual #61                 // Method saveFile:(Ljava/io/File;)V
         * 254: goto          298
         * 257: aload_0
         * 258: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 261: ldc           #62                 // String Ya hay un archivo con este nombre, ¿desea sobreescribirlo?
         * 263: ldc           #63                 // String Sobreescribir archivo
         * 265: iconst_2
         * 266: invokestatic  #64                 // Method javax/swing/JOptionPane.showConfirmDialog:(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)I
         * 269: istore        6
         * 271: iload         6
         * 273: ifne          281
         * 276: aload_0
         * 277: aload_1
         * 278: invokevirtual #61                 // Method saveFile:(Ljava/io/File;)V
         * 281: goto          298
         * 284: aload_0
         * 285: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 288: ldc           #65                 // String Escriba un nombre válido para el archivo
         * 290: ldc           #66                 // String Nombre inválido
         * 292: iconst_2
         * 293: invokestatic  #67                 // Method javax/swing/JOptionPane.showMessageDialog:(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
         * 296: iconst_0
         * 297: ireturn
         * 298: goto          303
         * 301: iconst_1
         * 302: ireturn
         * 303: goto          330
         * 306: aload_0
         * 307: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 310: ldc           #62                 // String Ya hay un archivo con este nombre, ¿desea sobreescribirlo?
         * 312: ldc           #63                 // String Sobreescribir archivo
         * 314: iconst_2
         * 315: invokestatic  #64                 // Method javax/swing/JOptionPane.showConfirmDialog:(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)I
         * 318: istore        4
         * 320: iload         4
         * 322: ifne          330
         * 325: aload_0
         * 326: aload_1
         * 327: invokevirtual #61                 // Method saveFile:(Ljava/io/File;)V
         * 330: iconst_1
         * 331: ireturn
         *  */
        // </editor-fold>
    }
    private void saveEditOpen(File file, JFileChooser jfc){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: aload_0
         * 1: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 4: invokevirtual #39                 // Method javax/swing/JFrame.getTitle:()Ljava/lang/String;
         * 7: aload_0
         * 8: getfield      #9                  // Field title:Ljava/lang/String;
         * 11: invokedynamic #40,  0             // InvokeDynamic #5:makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
         * 16: invokevirtual #41                 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
         * 19: ifeq          27
         * 22: iconst_0
         * 23: istore_3
         * 24: goto          52
         * 27: aload_0
         * 28: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 31: ldc           #42                 // String El archivo actual está siendo editado, ¿desea guardar los cambios?
         * 33: ldc           #43                 // String ¿Descartar edición?
         * 35: iconst_m1
         * 36: iconst_3
         * 37: aconst_null
         * 38: aload_0
         * 39: getfield      #8                  // Field options:[Ljava/lang/String;
         * 42: aload_0
         * 43: getfield      #8                  // Field options:[Ljava/lang/String;
         * 46: iconst_0
         * 47: aaload
         * 48: invokestatic  #44                 // Method javax/swing/JOptionPane.showOptionDialog:(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;IILjavax/swing/Icon;[Ljava/lang/Object;Ljava/lang/Object;)I
         * 51: istore_3
         * 52: iload_3
         * 53: ifne          324
         * 56: aload_2
         * 57: invokevirtual #45                 // Method javax/swing/JFileChooser.getSelectedFile:()Ljava/io/File;
         * 60: ifnull        96
         * 63: aload_0
         * 64: aload_1
         * 65: aload_0
         * 66: getfield      #12                 // Field jTextComponent:Ljavax/swing/text/JTextComponent;
         * 69: invokevirtual #46                 // Method javax/swing/text/JTextComponent.getText:()Ljava/lang/String;
         * 72: invokevirtual #47                 // Method saveFile:(Ljava/io/File;Ljava/lang/String;)Z
         * 75: istore        4
         * 77: iload         4
         * 79: ifeq          93
         * 82: aload_0
         * 83: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 86: aload_1
         * 87: invokevirtual #48                 // Method java/io/File.getName:()Ljava/lang/String;
         * 90: invokevirtual #49                 // Method javax/swing/JFrame.setTitle:(Ljava/lang/String;)V
         * 93: goto          344
         * 96: aload_0
         * 97: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 100: invokevirtual #39                 // Method javax/swing/JFrame.getTitle:()Ljava/lang/String;
         * 103: aload_0
         * 104: getfield      #9                  // Field title:Ljava/lang/String;
         * 107: invokedynamic #40,  0             // InvokeDynamic #5:makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
         * 112: invokevirtual #41                 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
         * 115: ifeq          344
         * 118: aload_0
         * 119: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 122: ldc           #50                 // String ¿Desea guardar el archivo actual?
         * 124: ldc           #51                 // String ¿Descartar edición de archivo nuevo?
         * 126: iconst_m1
         * 127: iconst_3
         * 128: aconst_null
         * 129: aload_0
         * 130: getfield      #8                  // Field options:[Ljava/lang/String;
         * 133: aload_0
         * 134: getfield      #8                  // Field options:[Ljava/lang/String;
         * 137: iconst_0
         * 138: aaload
         * 139: invokestatic  #44                 // Method javax/swing/JOptionPane.showOptionDialog:(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;IILjavax/swing/Icon;[Ljava/lang/Object;Ljava/lang/Object;)I
         * 142: istore        4
         * 144: iload         4
         * 146: ifne          301
         * 149: aload_2
         * 150: aload_0
         * 151: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 154: ldc           #52                 // String Guardar
         * 156: invokevirtual #53                 // Method javax/swing/JFileChooser.showDialog:(Ljava/awt/Component;Ljava/lang/String;)I
         * 159: ifne          321
         * 162: aload_2
         * 163: invokevirtual #45                 // Method javax/swing/JFileChooser.getSelectedFile:()Ljava/io/File;
         * 166: astore_1
         * 167: aload_1
         * 168: invokevirtual #48                 // Method java/io/File.getName:()Ljava/lang/String;
         * 171: astore        5
         * 173: aload         5
         * 175: aload_0
         * 176: getfield      #10                 // Field extension:Ljava/lang/String;
         * 179: invokevirtual #54                 // Method java/lang/String.endsWith:(Ljava/lang/String;)Z
         * 182: ifne          198
         * 185: aload         5
         * 187: aload_0
         * 188: getfield      #10                 // Field extension:Ljava/lang/String;
         * 191: invokedynamic #55,  0             // InvokeDynamic #1:makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
         * 196: astore        5
         * 198: aload_0
         * 199: aload         5
         * 201: invokevirtual #56                 // Method fileNameValid:(Ljava/lang/String;)Z
         * 204: ifeq          284
         * 207: aload_1
         * 208: invokevirtual #48                 // Method java/io/File.getName:()Ljava/lang/String;
         * 211: aload_0
         * 212: getfield      #10                 // Field extension:Ljava/lang/String;
         * 215: invokevirtual #54                 // Method java/lang/String.endsWith:(Ljava/lang/String;)Z
         * 218: ifne          242
         * 221: new           #57                 // class java/io/File
         * 224: dup
         * 225: aload_1
         * 226: invokevirtual #58                 // Method java/io/File.getAbsolutePath:()Ljava/lang/String;
         * 229: aload_0
         * 230: getfield      #10                 // Field extension:Ljava/lang/String;
         * 233: invokedynamic #55,  0             // InvokeDynamic #1:makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
         * 238: invokespecial #59                 // Method java/io/File."<init>":(Ljava/lang/String;)V
         * 241: astore_1
         * 242: aload_1
         * 243: invokevirtual #60                 // Method java/io/File.exists:()Z
         * 246: ifne          257
         * 249: aload_0
         * 250: aload_1
         * 251: invokevirtual #61                 // Method saveFile:(Ljava/io/File;)V
         * 254: goto          298
         * 257: aload_0
         * 258: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 261: ldc           #62                 // String Ya hay un archivo con este nombre, ¿desea sobreescribirlo?
         * 263: ldc           #63                 // String Sobreescribir archivo
         * 265: iconst_2
         * 266: invokestatic  #64                 // Method javax/swing/JOptionPane.showConfirmDialog:(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)I
         * 269: istore        6
         * 271: iload         6
         * 273: ifne          281
         * 276: aload_0
         * 277: aload_1
         * 278: invokevirtual #61                 // Method saveFile:(Ljava/io/File;)V
         * 281: goto          298
         * 284: aload_0
         * 285: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 288: ldc           #65                 // String Escriba un nombre válido para el archivo
         * 290: ldc           #66                 // String Nombre inválido
         * 292: iconst_2
         * 293: invokestatic  #67                 // Method javax/swing/JOptionPane.showMessageDialog:(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
         * 296: iconst_0
         * 297: ireturn
         * 298: goto          321
         * 301: aload_0
         * 302: getfield      #12                 // Field jTextComponent:Ljavax/swing/text/JTextComponent;
         * 305: ldc           #17                 // String
         * 307: invokevirtual #68                 // Method javax/swing/text/JTextComponent.setText:(Ljava/lang/String;)V
         * 310: aload_0
         * 311: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 314: aload_0
         * 315: getfield      #9                  // Field title:Ljava/lang/String;
         * 318: invokevirtual #49                 // Method javax/swing/JFrame.setTitle:(Ljava/lang/String;)V
         * 321: goto          344
         * 324: aload_0
         * 325: getfield      #12                 // Field jTextComponent:Ljavax/swing/text/JTextComponent;
         * 328: ldc           #17                 // String
         * 330: invokevirtual #68                 // Method javax/swing/text/JTextComponent.setText:(Ljava/lang/String;)V
         * 333: aload_0
         * 334: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 337: aload_0
         * 338: getfield      #9                  // Field title:Ljava/lang/String;
         * 341: invokevirtual #49                 // Method javax/swing/JFrame.setTitle:(Ljava/lang/String;)V
         * 344: iconst_1
         * 345: ireturn
         *  */
        // </editor-fold>
    }
    private void saveFile(File file){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: aload_0
         * 1: aload_1
         * 2: aload_0
         * 3: getfield      #12                 // Field jTextComponent:Ljavax/swing/text/JTextComponent;
         * 6: invokevirtual #46                 // Method javax/swing/text/JTextComponent.getText:()Ljava/lang/String;
         * 9: invokevirtual #47                 // Method saveFile:(Ljava/io/File;Ljava/lang/String;)Z
         * 12: istore_2
         * 13: iload_2
         * 14: ifeq          31
         * 17: aload_0
         * 18: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 21: aload_1
         * 22: invokevirtual #48                 // Method java/io/File.getName:()Ljava/lang/String;
         * 25: invokevirtual #49                 // Method javax/swing/JFrame.setTitle:(Ljava/lang/String;)V
         * 28: goto          43
         * 31: aload_0
         * 32: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 35: ldc           #69                 // String No se pudo guardar el archivo
         * 37: ldc           #70                 // String Error desconocido
         * 39: iconst_2
         * 40: invokestatic  #67                 // Method javax/swing/JOptionPane.showMessageDialog:(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
         * 43: return
         *  */
        // </editor-fold>
    }
    private void fileNameValid(String string){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: aload_1
         * 1: ldc           #71                 // String .
         * 3: invokevirtual #72                 // Method java/lang/String.lastIndexOf:(Ljava/lang/String;)I
         * 6: istore_2
         * 7: aload_1
         * 8: iconst_0
         * 9: iload_2
         * 10: invokevirtual #73                 // Method java/lang/String.substring:(II)Ljava/lang/String;
         * 13: astore_3
         * 14: aload_3
         * 15: ldc           #74                 // String
         * 17: ldc           #17                 // String
         * 19: invokevirtual #75                 // Method java/lang/String.replace:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
         * 22: ldc           #17                 // String
         * 24: invokevirtual #41                 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
         * 27: ifne          115
         * 30: aload_1
         * 31: ldc           #76                 // String \\
         * 33: invokevirtual #77                 // Method java/lang/String.contains:(Ljava/lang/CharSequence;)Z
         * 36: ifne          115
         * 39: aload_1
         * 40: ldc           #78                 // String /
         * 42: invokevirtual #77                 // Method java/lang/String.contains:(Ljava/lang/CharSequence;)Z
         * 45: ifne          115
         * 48: aload_1
         * 49: ldc           #79                 // String :
         * 51: invokevirtual #77                 // Method java/lang/String.contains:(Ljava/lang/CharSequence;)Z
         * 54: ifne          115
         * 57: aload_1
         * 58: ldc           #80                 // String *
         * 60: invokevirtual #77                 // Method java/lang/String.contains:(Ljava/lang/CharSequence;)Z
         * 63: ifne          115
         * 66: aload_1
         * 67: ldc           #81                 // String ?
         * 69: invokevirtual #77                 // Method java/lang/String.contains:(Ljava/lang/CharSequence;)Z
         * 72: ifne          115
         * 75: aload_1
         * 76: ldc           #82                 // String \"
         * 78: invokevirtual #77                 // Method java/lang/String.contains:(Ljava/lang/CharSequence;)Z
         * 81: ifne          115
         * 84: aload_1
         * 85: ldc           #83                 // String <
         * 87: invokevirtual #77                 // Method java/lang/String.contains:(Ljava/lang/CharSequence;)Z
         * 90: ifne          115
         * 93: aload_1
         * 94: ldc           #84                 // String >
         * 96: invokevirtual #77                 // Method java/lang/String.contains:(Ljava/lang/CharSequence;)Z
         * 99: ifne          115
         * 102: aload_1
         * 103: ldc           #85                 // String |
         * 105: invokevirtual #77                 // Method java/lang/String.contains:(Ljava/lang/CharSequence;)Z
         * 108: ifne          115
         * 111: iconst_1
         * 112: goto          116
         * 115: iconst_0
         * 116: ireturn
         *  */
        // </editor-fold>
    }
    public void New(){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: aload_0
         * 1: aload_0
         * 2: getfield      #4                  // Field selecFile:Ljavax/swing/JFileChooser;
         * 5: invokevirtual #45                 // Method javax/swing/JFileChooser.getSelectedFile:()Ljava/io/File;
         * 8: putfield      #86                 // Field file:Ljava/io/File;
         * 11: aload_0
         * 12: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 15: invokevirtual #39                 // Method javax/swing/JFrame.getTitle:()Ljava/lang/String;
         * 18: ldc           #80                 // String *
         * 20: invokevirtual #77                 // Method java/lang/String.contains:(Ljava/lang/CharSequence;)Z
         * 23: ifeq          80
         * 26: aload_0
         * 27: aload_0
         * 28: getfield      #86                 // Field file:Ljava/io/File;
         * 31: aload_0
         * 32: getfield      #4                  // Field selecFile:Ljavax/swing/JFileChooser;
         * 35: invokevirtual #87                 // Method saveEditNew:(Ljava/io/File;Ljavax/swing/JFileChooser;)Z
         * 38: ifeq          116
         * 41: aload_0
         * 42: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 45: aload_0
         * 46: getfield      #9                  // Field title:Ljava/lang/String;
         * 49: invokevirtual #49                 // Method javax/swing/JFrame.setTitle:(Ljava/lang/String;)V
         * 52: aload_0
         * 53: getfield      #12                 // Field jTextComponent:Ljavax/swing/text/JTextComponent;
         * 56: ldc           #17                 // String
         * 58: invokevirtual #68                 // Method javax/swing/text/JTextComponent.setText:(Ljava/lang/String;)V
         * 61: aload_0
         * 62: new           #2                  // class javax/swing/JFileChooser
         * 65: dup
         * 66: invokespecial #3                  // Method javax/swing/JFileChooser."<init>":()V
         * 69: putfield      #4                  // Field selecFile:Ljavax/swing/JFileChooser;
         * 72: aload_0
         * 73: aconst_null
         * 74: putfield      #86                 // Field file:Ljava/io/File;
         * 77: goto          116
         * 80: aload_0
         * 81: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 84: aload_0
         * 85: getfield      #9                  // Field title:Ljava/lang/String;
         * 88: invokevirtual #49                 // Method javax/swing/JFrame.setTitle:(Ljava/lang/String;)V
         * 91: aload_0
         * 92: getfield      #12                 // Field jTextComponent:Ljavax/swing/text/JTextComponent;
         * 95: ldc           #17                 // String
         * 97: invokevirtual #68                 // Method javax/swing/text/JTextComponent.setText:(Ljava/lang/String;)V
         * 100: aload_0
         * 101: new           #2                  // class javax/swing/JFileChooser
         * 104: dup
         * 105: invokespecial #3                  // Method javax/swing/JFileChooser."<init>":()V
         * 108: putfield      #4                  // Field selecFile:Ljavax/swing/JFileChooser;
         * 111: aload_0
         * 112: aconst_null
         * 113: putfield      #86                 // Field file:Ljava/io/File;
         * 116: return
         *  */
        // </editor-fold>
    }
    public void Exit(){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: aload_0
         * 1: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 4: invokevirtual #39                 // Method javax/swing/JFrame.getTitle:()Ljava/lang/String;
         * 7: ldc           #80                 // String *
         * 9: invokevirtual #77                 // Method java/lang/String.contains:(Ljava/lang/CharSequence;)Z
         * 12: ifeq          46
         * 15: aload_0
         * 16: aload_0
         * 17: getfield      #86                 // Field file:Ljava/io/File;
         * 20: aload_0
         * 21: getfield      #4                  // Field selecFile:Ljavax/swing/JFileChooser;
         * 24: invokevirtual #88                 // Method saveEditOpen:(Ljava/io/File;Ljavax/swing/JFileChooser;)Z
         * 27: ifeq          46
         * 30: aload_0
         * 31: new           #2                  // class javax/swing/JFileChooser
         * 34: dup
         * 35: invokespecial #3                  // Method javax/swing/JFileChooser."<init>":()V
         * 38: putfield      #4                  // Field selecFile:Ljavax/swing/JFileChooser;
         * 41: aload_0
         * 42: aconst_null
         * 43: putfield      #86                 // Field file:Ljava/io/File;
         * 46: return
         *  */
        // </editor-fold>
    }
    public void Open(){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: aload_0
         * 1: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 4: invokevirtual #39                 // Method javax/swing/JFrame.getTitle:()Ljava/lang/String;
         * 7: ldc           #80                 // String *
         * 9: invokevirtual #77                 // Method java/lang/String.contains:(Ljava/lang/CharSequence;)Z
         * 12: ifeq          28
         * 15: aload_0
         * 16: aload_0
         * 17: getfield      #86                 // Field file:Ljava/io/File;
         * 20: aload_0
         * 21: getfield      #4                  // Field selecFile:Ljavax/swing/JFileChooser;
         * 24: invokevirtual #88                 // Method saveEditOpen:(Ljava/io/File;Ljavax/swing/JFileChooser;)Z
         * 27: pop
         * 28: new           #2                  // class javax/swing/JFileChooser
         * 31: dup
         * 32: invokespecial #3                  // Method javax/swing/JFileChooser."<init>":()V
         * 35: astore_1
         * 36: aload_1
         * 37: aload_0
         * 38: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 41: ldc           #89                 // String Abrir
         * 43: invokevirtual #53                 // Method javax/swing/JFileChooser.showDialog:(Ljava/awt/Component;Ljava/lang/String;)I
         * 46: ifne          200
         * 49: aload_1
         * 50: invokevirtual #45                 // Method javax/swing/JFileChooser.getSelectedFile:()Ljava/io/File;
         * 53: astore_2
         * 54: aload_2
         * 55: invokevirtual #48                 // Method java/io/File.getName:()Ljava/lang/String;
         * 58: astore_3
         * 59: aload_3
         * 60: aload_0
         * 61: getfield      #10                 // Field extension:Ljava/lang/String;
         * 64: invokevirtual #54                 // Method java/lang/String.endsWith:(Ljava/lang/String;)Z
         * 67: ifeq          176
         * 70: aload_0
         * 71: aload_3
         * 72: invokevirtual #56                 // Method fileNameValid:(Ljava/lang/String;)Z
         * 75: ifeq          162
         * 78: aload_2
         * 79: invokevirtual #60                 // Method java/io/File.exists:()Z
         * 82: ifne          100
         * 85: aload_0
         * 86: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 89: ldc           #90                 // String El archivo que sea desea abrir no existe en el directorio especificado
         * 91: ldc           #91                 // String Archivo no encontrado
         * 93: iconst_2
         * 94: invokestatic  #67                 // Method javax/swing/JOptionPane.showMessageDialog:(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
         * 97: goto          197
         * 100: aload_0
         * 101: aload_2
         * 102: invokevirtual #92                 // Method getTextFile:(Ljava/io/File;)Ljava/lang/String;
         * 105: astore        4
         * 107: aload         4
         * 109: ifnull        145
         * 112: aload_0
         * 113: getfield      #12                 // Field jTextComponent:Ljavax/swing/text/JTextComponent;
         * 116: aload         4
         * 118: invokevirtual #68                 // Method javax/swing/text/JTextComponent.setText:(Ljava/lang/String;)V
         * 121: aload_0
         * 122: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 125: aload_2
         * 126: invokevirtual #48                 // Method java/io/File.getName:()Ljava/lang/String;
         * 129: invokevirtual #49                 // Method javax/swing/JFrame.setTitle:(Ljava/lang/String;)V
         * 132: aload_0
         * 133: aload_1
         * 134: putfield      #4                  // Field selecFile:Ljavax/swing/JFileChooser;
         * 137: aload_0
         * 138: aload_2
         * 139: putfield      #86                 // Field file:Ljava/io/File;
         * 142: goto          159
         * 145: aload_0
         * 146: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 149: ldc           #93                 // String Error al leer el archivo
         * 151: ldc           #70                 // String Error desconocido
         * 153: iconst_2
         * 154: invokestatic  #67                 // Method javax/swing/JOptionPane.showMessageDialog:(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
         * 157: iconst_0
         * 158: ireturn
         * 159: goto          197
         * 162: aload_0
         * 163: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 166: ldc           #65                 // String Escriba un nombre válido para el archivo
         * 168: ldc           #66                 // String Nombre inválido
         * 170: iconst_2
         * 171: invokestatic  #67                 // Method javax/swing/JOptionPane.showMessageDialog:(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
         * 174: iconst_0
         * 175: ireturn
         * 176: aload_0
         * 177: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 180: aload_0
         * 181: getfield      #10                 // Field extension:Ljava/lang/String;
         * 184: invokedynamic #94,  0             // InvokeDynamic #6:makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
         * 189: ldc           #95                 // String Extensión inválida
         * 191: iconst_2
         * 192: invokestatic  #67                 // Method javax/swing/JOptionPane.showMessageDialog:(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
         * 195: iconst_0
         * 196: ireturn
         * 197: goto          202
         * 200: iconst_0
         * 201: ireturn
         * 202: aload_0
         * 203: getfield      #12                 // Field jTextComponent:Ljavax/swing/text/JTextComponent;
         * 206: iconst_0
         * 207: invokevirtual #96                 // Method javax/swing/text/JTextComponent.setCaretPosition:(I)V
         * 210: iconst_1
         * 211: ireturn
         *  */
        // </editor-fold>
    }
    public void Save(){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: aload_0
         * 1: getfield      #86                 // Field file:Ljava/io/File;
         * 4: ifnull        18
         * 7: aload_0
         * 8: aload_0
         * 9: getfield      #86                 // Field file:Ljava/io/File;
         * 12: invokevirtual #61                 // Method saveFile:(Ljava/io/File;)V
         * 15: goto          232
         * 18: new           #2                  // class javax/swing/JFileChooser
         * 21: dup
         * 22: invokespecial #3                  // Method javax/swing/JFileChooser."<init>":()V
         * 25: astore_1
         * 26: aload_1
         * 27: aload_0
         * 28: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 31: ldc           #52                 // String Guardar
         * 33: invokevirtual #53                 // Method javax/swing/JFileChooser.showDialog:(Ljava/awt/Component;Ljava/lang/String;)I
         * 36: ifne          230
         * 39: aload_1
         * 40: invokevirtual #45                 // Method javax/swing/JFileChooser.getSelectedFile:()Ljava/io/File;
         * 43: astore_2
         * 44: aload_2
         * 45: invokevirtual #48                 // Method java/io/File.getName:()Ljava/lang/String;
         * 48: astore_3
         * 49: aload_3
         * 50: aload_0
         * 51: getfield      #10                 // Field extension:Ljava/lang/String;
         * 54: invokevirtual #54                 // Method java/lang/String.endsWith:(Ljava/lang/String;)Z
         * 57: ifne          71
         * 60: aload_3
         * 61: aload_0
         * 62: getfield      #10                 // Field extension:Ljava/lang/String;
         * 65: invokedynamic #55,  0             // InvokeDynamic #1:makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
         * 70: astore_3
         * 71: aload_0
         * 72: aload_3
         * 73: invokevirtual #56                 // Method fileNameValid:(Ljava/lang/String;)Z
         * 76: ifeq          197
         * 79: aload_2
         * 80: invokevirtual #48                 // Method java/io/File.getName:()Ljava/lang/String;
         * 83: aload_0
         * 84: getfield      #10                 // Field extension:Ljava/lang/String;
         * 87: invokevirtual #54                 // Method java/lang/String.endsWith:(Ljava/lang/String;)Z
         * 90: ifne          114
         * 93: new           #57                 // class java/io/File
         * 96: dup
         * 97: aload_2
         * 98: invokevirtual #58                 // Method java/io/File.getAbsolutePath:()Ljava/lang/String;
         * 101: aload_0
         * 102: getfield      #10                 // Field extension:Ljava/lang/String;
         * 105: invokedynamic #55,  0             // InvokeDynamic #1:makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
         * 110: invokespecial #59                 // Method java/io/File."<init>":(Ljava/lang/String;)V
         * 113: astore_2
         * 114: aload_2
         * 115: invokevirtual #60                 // Method java/io/File.exists:()Z
         * 118: ifne          139
         * 121: aload_0
         * 122: aload_2
         * 123: invokevirtual #61                 // Method saveFile:(Ljava/io/File;)V
         * 126: aload_0
         * 127: aload_2
         * 128: putfield      #86                 // Field file:Ljava/io/File;
         * 131: aload_0
         * 132: aload_1
         * 133: putfield      #4                  // Field selecFile:Ljavax/swing/JFileChooser;
         * 136: goto          227
         * 139: aload_0
         * 140: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 143: ldc           #62                 // String Ya hay un archivo con este nombre, ¿desea sobreescribirlo?
         * 145: ldc           #63                 // String Sobreescribir archivo
         * 147: iconst_2
         * 148: invokestatic  #64                 // Method javax/swing/JOptionPane.showConfirmDialog:(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)I
         * 151: istore        4
         * 153: iload         4
         * 155: ifne          176
         * 158: aload_0
         * 159: aload_2
         * 160: invokevirtual #61                 // Method saveFile:(Ljava/io/File;)V
         * 163: aload_0
         * 164: aload_2
         * 165: putfield      #86                 // Field file:Ljava/io/File;
         * 168: aload_0
         * 169: aload_1
         * 170: putfield      #4                  // Field selecFile:Ljavax/swing/JFileChooser;
         * 173: goto          194
         * 176: aload_0
         * 177: new           #2                  // class javax/swing/JFileChooser
         * 180: dup
         * 181: invokespecial #3                  // Method javax/swing/JFileChooser."<init>":()V
         * 184: putfield      #4                  // Field selecFile:Ljavax/swing/JFileChooser;
         * 187: aload_0
         * 188: aconst_null
         * 189: putfield      #86                 // Field file:Ljava/io/File;
         * 192: iconst_0
         * 193: ireturn
         * 194: goto          227
         * 197: aload_0
         * 198: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 201: ldc           #65                 // String Escriba un nombre válido para el archivo
         * 203: ldc           #66                 // String Nombre inválido
         * 205: iconst_2
         * 206: invokestatic  #67                 // Method javax/swing/JOptionPane.showMessageDialog:(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
         * 209: aload_0
         * 210: new           #2                  // class javax/swing/JFileChooser
         * 213: dup
         * 214: invokespecial #3                  // Method javax/swing/JFileChooser."<init>":()V
         * 217: putfield      #4                  // Field selecFile:Ljavax/swing/JFileChooser;
         * 220: aload_0
         * 221: aconst_null
         * 222: putfield      #86                 // Field file:Ljava/io/File;
         * 225: iconst_0
         * 226: ireturn
         * 227: goto          232
         * 230: iconst_0
         * 231: ireturn
         * 232: iconst_1
         * 233: ireturn
         *  */
        // </editor-fold>
    }
    public void SaveAs(){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: new           #2                  // class javax/swing/JFileChooser
         * 3: dup
         * 4: invokespecial #3                  // Method javax/swing/JFileChooser."<init>":()V
         * 7: astore_1
         * 8: aload_1
         * 9: aload_0
         * 10: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 13: ldc           #97                 // String Guardar como
         * 15: invokevirtual #53                 // Method javax/swing/JFileChooser.showDialog:(Ljava/awt/Component;Ljava/lang/String;)I
         * 18: ifne          127
         * 21: aload_1
         * 22: invokevirtual #45                 // Method javax/swing/JFileChooser.getSelectedFile:()Ljava/io/File;
         * 25: astore_2
         * 26: aload_2
         * 27: invokevirtual #48                 // Method java/io/File.getName:()Ljava/lang/String;
         * 30: astore_3
         * 31: aload_3
         * 32: aload_0
         * 33: getfield      #10                 // Field extension:Ljava/lang/String;
         * 36: invokevirtual #54                 // Method java/lang/String.endsWith:(Ljava/lang/String;)Z
         * 39: ifne          53
         * 42: aload_3
         * 43: aload_0
         * 44: getfield      #10                 // Field extension:Ljava/lang/String;
         * 47: invokedynamic #55,  0             // InvokeDynamic #1:makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
         * 52: astore_3
         * 53: aload_0
         * 54: aload_3
         * 55: invokevirtual #56                 // Method fileNameValid:(Ljava/lang/String;)Z
         * 58: ifeq          113
         * 61: aload_2
         * 62: invokevirtual #48                 // Method java/io/File.getName:()Ljava/lang/String;
         * 65: aload_0
         * 66: getfield      #10                 // Field extension:Ljava/lang/String;
         * 69: invokevirtual #54                 // Method java/lang/String.endsWith:(Ljava/lang/String;)Z
         * 72: ifne          96
         * 75: new           #57                 // class java/io/File
         * 78: dup
         * 79: aload_2
         * 80: invokevirtual #58                 // Method java/io/File.getAbsolutePath:()Ljava/lang/String;
         * 83: aload_0
         * 84: getfield      #10                 // Field extension:Ljava/lang/String;
         * 87: invokedynamic #55,  0             // InvokeDynamic #1:makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
         * 92: invokespecial #59                 // Method java/io/File."<init>":(Ljava/lang/String;)V
         * 95: astore_2
         * 96: aload_0
         * 97: aload_2
         * 98: invokevirtual #61                 // Method saveFile:(Ljava/io/File;)V
         * 101: aload_0
         * 102: aload_2
         * 103: putfield      #86                 // Field file:Ljava/io/File;
         * 106: aload_0
         * 107: aload_1
         * 108: putfield      #4                  // Field selecFile:Ljavax/swing/JFileChooser;
         * 111: iconst_1
         * 112: ireturn
         * 113: aload_0
         * 114: getfield      #11                 // Field jFrame:Ljavax/swing/JFrame;
         * 117: ldc           #65                 // String Escriba un nombre válido para el archivo
         * 119: ldc           #66                 // String Nombre inválido
         * 121: iconst_2
         * 122: invokestatic  #67                 // Method javax/swing/JOptionPane.showMessageDialog:(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
         * 125: iconst_0
         * 126: ireturn
         * 127: iconst_0
         * 128: ireturn
         *  */
        // </editor-fold>
    }
    
}
