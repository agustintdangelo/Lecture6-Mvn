package com.solvd.javacourse.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reflection {
	private static final Logger LOG = Logger.getLogger(Reflection.class.getName());

	public static void main(String[] args) {
		try {
			Class<?> cls = Class.forName("com.solvd.javacourse.unit.Leader");
			LOG.log(Level.INFO, "Methods of Leader: ");
			Method methlist[] = cls.getDeclaredMethods();
			for (int i = 0; i < methlist.length; i++) {
				Method m = methlist[i];
				LOG.log(Level.INFO, "name = " + m.getName());
				LOG.log(Level.INFO, "decl class = " + m.getDeclaringClass());
				Class<?> pvec[] = m.getParameterTypes();
				for (int j = 0; j < pvec.length; j++)
					LOG.log(Level.INFO, "param #" + j + " " + pvec[j]);
				Class<?> evec[] = m.getExceptionTypes();
				for (int j = 0; j < evec.length; j++)
					LOG.log(Level.INFO, "exc #" + j + " " + evec[j]);
				LOG.log(Level.INFO, "return type = " + m.getReturnType());
				LOG.log(Level.INFO, "-----");
			}
		} catch (Throwable e) {
			System.err.println(e);
		}

		try {
			Class<?> cls = Class.forName("com.solvd.javacourse.spaceArmy.SpaceArmy");
			LOG.log(Level.INFO, "Constructors of SpaceArmy: ");
			Constructor<?> ctorlist[] = cls.getDeclaredConstructors();
			for (int i = 0; i < ctorlist.length; i++) {
				Constructor<?> ct = ctorlist[i];
				LOG.log(Level.INFO, "name = " + ct.getName());
				LOG.log(Level.INFO, "decl class = " + ct.getDeclaringClass());
				Class<?> pvec[] = ct.getParameterTypes();
				for (int j = 0; j < pvec.length; j++)
					LOG.log(Level.INFO, "param #" + j + " " + pvec[j]);
				Class<?> evec[] = ct.getExceptionTypes();
				for (int j = 0; j < evec.length; j++)
					LOG.log(Level.INFO, "exc #" + j + " " + evec[j]);
				LOG.log(Level.INFO, "-----");
			}
		} catch (Throwable e) {
			System.err.println(e);
		}

		try {
			Class<?> cls = Class.forName("com.solvd.javacourse.unit.RebelCommando");
			LOG.log(Level.INFO, "Fields of RebelCommando: ");
			Field fieldlist[] = cls.getDeclaredFields();
			for (int i = 0; i < fieldlist.length; i++) {
				Field fld = fieldlist[i];
				LOG.log(Level.INFO, "name = " + fld.getName());
				LOG.log(Level.INFO, "decl class = " + fld.getDeclaringClass());
				LOG.log(Level.INFO, "type = " + fld.getType());
				int mod = fld.getModifiers();
				LOG.log(Level.INFO, "modifiers = " + Modifier.toString(mod));
				LOG.log(Level.INFO, "-----");
			}
		} catch (Throwable e) {
			System.err.println(e);
		}
	}
}
