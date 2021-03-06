/*****************************************************************************
    This file is part of Git-Starteam.

    Git-Starteam is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Git-Starteam is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Git-Starteam.  If not, see <http://www.gnu.org/licenses/>.
******************************************************************************/
package org.ossnoize.git.fastimport;

import java.io.IOException;
import java.io.OutputStream;

public class FileDelete extends FileOperation {
	private final static String DELETE_SP = "D ";
	
	@Override
	public void writeTo(OutputStream out) throws IOException {
		if(null == Path) {
			throw new NullPointerException("Path cannot be null");
		}
		StringBuilder builder = new StringBuilder();
		builder.append(DELETE_SP);
		builder.append(Path);
		builder.append('\n');
		
		out.write(builder.toString().getBytes("UTF-8"));
	}

	@Override
	public boolean isInline() {
		return true;
	}

	@Override
	public MarkID getMark() {
		return null;
	}
}
