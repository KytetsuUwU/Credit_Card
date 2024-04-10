// Source code is decompiled from a .class file using FernFlower decompiler.
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Locale;

public class Ecran {
   public Ecran() {
   }

   public static void afficher(Object... var0) {
      int var1 = 0;
      Object[] var2 = var0;
      int var3 = var0.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Object var5 = var2[var4];
         ++var1;
         System.out.print(var5.toString());
      }

   }

   public static void afficherln(Object... var0) {
      Object[] var1 = var0;
      int var2 = var0.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Object var4 = var1[var3];
         System.out.print(var4.toString());
      }

      System.out.println();
   }

   public static void sautDeLigne() {
      System.out.println();
   }

   public static void formater(String var0, Object... var1) {
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();
      PrintStream var3 = new PrintStream(var2);
      var3.printf(Locale.US, var0, var1);
      System.out.print(var2);
   }

   private static boolean estPredefini(Class var0) {
      String var1 = var0.getName();
      return var1.equals("java.lang.Byte") || var1.equals("java.lang.Short") || var1.equals("java.lang.Float") || var1.equals("java.lang.Double") || var1.equals("java.lang.Boolean") || var1.equals("java.lang.String") || var1.equals("java.lang.Integer") || var1.equals("java.lang.Long") || var1.equals("java.lang.Character");
   }

   private static void afficherTableau(Object var0) {
      int var2;
      if (var0.getClass().getComponentType().toString().equals("int")) {
         int[] var10 = (int[])((int[])var0);
         System.out.print("(");

         for(var2 = 0; var2 < var10.length; ++var2) {
            if (var2 != 0) {
               System.out.print(",");
            }

            System.out.print(var10[var2]);
         }

      } else if (var0.getClass().getComponentType().toString().equals("double")) {
         double[] var9 = (double[])((double[])var0);
         System.out.print("(");

         for(var2 = 0; var2 < var9.length; ++var2) {
            if (var2 != 0) {
               System.out.print(",");
            }

            System.out.print(var9[var2]);
         }

      } else if (var0.getClass().getComponentType().toString().equals("long")) {
         long[] var8 = (long[])((long[])var0);
         System.out.print("(");

         for(var2 = 0; var2 < var8.length; ++var2) {
            if (var2 != 0) {
               System.out.print(",");
            }

            System.out.print(var8[var2]);
         }

      } else if (var0.getClass().getComponentType().toString().equals("short")) {
         short[] var7 = (short[])((short[])var0);
         System.out.print("(");

         for(var2 = 0; var2 < var7.length; ++var2) {
            if (var2 != 0) {
               System.out.print(",");
            }

            System.out.print(var7[var2]);
         }

      } else if (var0.getClass().getComponentType().toString().equals("float")) {
         float[] var6 = (float[])((float[])var0);
         System.out.print("(");

         for(var2 = 0; var2 < var6.length; ++var2) {
            if (var2 != 0) {
               System.out.print(",");
            }

            System.out.print(var6[var2]);
         }

      } else if (var0.getClass().getComponentType().toString().equals("boolean")) {
         boolean[] var5 = (boolean[])((boolean[])var0);
         System.out.print("(");

         for(var2 = 0; var2 < var5.length; ++var2) {
            if (var2 != 0) {
               System.out.print(",");
            }

            System.out.print(var5[var2]);
         }

      } else if (var0.getClass().getComponentType().toString().equals("byte")) {
         byte[] var4 = (byte[])((byte[])var0);
         System.out.print("(");

         for(var2 = 0; var2 < var4.length; ++var2) {
            if (var2 != 0) {
               System.out.print(",");
            }

            System.out.print(var4[var2]);
         }

      } else if (var0.getClass().getComponentType().toString().equals("char")) {
         char[] var3 = (char[])((char[])var0);
         System.out.print("(");

         for(var2 = 0; var2 < var3.length; ++var2) {
            if (var2 != 0) {
               System.out.print(",");
            }

            System.out.print(var3[var2]);
         }

      } else if (var0.getClass().getComponentType().toString().equals("String")) {
         String[] var1 = (String[])((String[])var0);
         System.out.print("(");

         for(var2 = 0; var2 < var1.length; ++var2) {
            if (var2 != 0) {
               System.out.print(",");
            }

            System.out.print(var1[var2]);
         }

      }
   }

   private static void afficherType2(Object var0) {
      if (var0 == null) {
         System.out.print("null");
      } else {
         Class var1 = var0.getClass();
         int var3;
         if (var1.isArray()) {
            if (var1.getComponentType().isPrimitive()) {
               afficherTableau(var0);
            } else {
               Object[] var2 = (Object[])((Object[])var0);
               System.out.print("(");

               for(var3 = 0; var3 < var2.length; ++var3) {
                  if (var3 != 0) {
                     System.out.print(",");
                  }

                  afficherType2(var2[var3]);
               }
            }

            System.out.print(")");
         } else if (estPredefini(var1)) {
            System.out.print(var0);
         } else {
            Field[] var6 = var1.getDeclaredFields();
            System.out.print("(");

            for(var3 = 0; var3 < var6.length; ++var3) {
               if (var3 != 0) {
                  System.out.print(",");
               }

               try {
                  afficherType2(var6[var3].get(var0));
               } catch (IllegalAccessException var5) {
               }
            }

            System.out.print(")");
         }

      }
   }

   private static void afficherType(boolean var0, Object... var1) {
      Object[] var2 = var1;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Object var5 = var2[var4];
         afficherType2(var5);
      }

      if (var0) {
         System.out.println();
      }

   }

   private static void afficherType(Object... var0) {
      afficherType(false, var0);
   }
}
