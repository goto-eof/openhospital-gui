/*
 * Open Hospital (www.open-hospital.org)
 * Copyright © 2006-2021 Informatici Senza Frontiere (info@informaticisenzafrontiere.org)
 *
 * Open Hospital is a free and open source software for healthcare data management.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * https://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.isf.menu.gui;

import java.awt.MouseInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionRefreshedRunnable implements Runnable {

	private static final Logger LOGGER = LoggerFactory.getLogger(SessionRefreshedRunnable.class);
	
	private double x;
	private double y;

	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(5000);
				double x = MouseInfo.getPointerInfo().getLocation().getX();
				double y = MouseInfo.getPointerInfo().getLocation().getY();

				if (x != this.x || y != this.y) {
					if (UserSession.getTimer() != null) {
						UserSession.getTimer().startTimer();
						LOGGER.debug("Mouse moved...session refreshed");
					}
					this.x = x;
					this.y = y;
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
